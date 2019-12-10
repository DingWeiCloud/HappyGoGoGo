package com.happy.boot.controller;

import com.happy.boot.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取yml配置文件中的配置
 *
 * @className: HelloController
 * @package: com.happy.boot
 * @author: DingWei
 * @date: 2019/12/8 17:30
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;

    @RequestMapping("/")
    public String index() {
        return name + ":" + age;
    }
    @Autowired
    ConfigBean configBean;
    @RequestMapping("/hi")
    String mimy(){
        return configBean.getGreeting()+">>>>>>>>>"+configBean.getName()+">>>>>>>>>>"+configBean.getAge()+">>>>>>>>>>"+ configBean.getUuid()+configBean.getMax();
    }


}
