package com.happy.boot.controller;

import com.happy.boot.entity.ConfigBean;
import com.happy.boot.entity.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :: <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  19:45
 * @description :
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, Properties.class})
public class PropertiesController {
    @Autowired
    ConfigBean configBean;
    @RequestMapping("/yml")
    public String yml(){
        return configBean.getGreeting()+">>>>>>>>>"+configBean.getName()+">>>>>>>>>>"+configBean.getAge()+">>>>>>>>>>"+ configBean.getUuid()+configBean.getMax();
    }
    @Autowired
    Properties properties;
    @RequestMapping("properties")
    public String properties(){
        return properties.getName()+ properties.getAge();
    }
}
