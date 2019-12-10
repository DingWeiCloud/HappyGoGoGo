package com.happy.service;

import org.springframework.stereotype.Component;

/**
 * @author : <a href="mailto:dingweixie@ebnew.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  10:17
 * @description :
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "feign熔断器出错通知 : "+name;
    }
}
