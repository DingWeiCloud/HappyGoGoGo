在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务网关（zuul集群），
然后再到具体的服。，服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理（下一篇文章讲述），配置服务的配置文件
放在git仓库，方便开发人员随时改配置。
**Zuul简介**
Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。

**zuul有以下功能：**
    Authentication
    Insights
    Stress Testing
    Canary Testing
    Dynamic Routing
    Service Migration
    Load Shedding
    Security
    Static Response handling
    Active/Active traffic management
 **路由**
  首先指定服务注册中心的地址为http://localhost:8761/eureka/，服务的端口为8769，服务名为service-zuul；以/api-a/ 开头的请求都转发给service-ribbon服务；以/api-b/开头的请求都转发给service-feign服务；
   
   依次运行这五个工程;打开浏览器访问：http://localhost:8769/api-a/hi?name=forezp ;浏览器显示：
   
   hi forezp,i am from port:8762
   
   打开浏览器访问：http://localhost:8769/api-b/hi?name=forezp ;浏览器显示：
   
   hi forezp,i am from port:8762
   
   这说明zuul起到了路由的作用
   
 **过滤**
  zuul不仅只是路由，并且还能过滤，做一些安全验证