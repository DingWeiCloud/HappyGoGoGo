package com.happy.boot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @version : v1.0
 * @author: <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @date :  2019/12/10  19:41
 * @description :
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "com.happy")
public class Properties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
