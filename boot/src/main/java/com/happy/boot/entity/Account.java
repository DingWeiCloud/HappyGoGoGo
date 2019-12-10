package com.happy.boot.entity;

/**
 * @author : <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  20:10
 * @description : springboot通过jdbc访问关系型mysql,通过spring的JdbcTemplate去访问
 */
public class Account {
    private int id ;
    private String name ;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
