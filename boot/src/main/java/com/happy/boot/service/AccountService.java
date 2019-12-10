package com.happy.boot.service;

import com.happy.boot.entity.Account;

import java.util.List;

/**
 * @author : <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  20:11
 * @description :springboot通过jdbc访问关系型mysql,通过spring的JdbcTemplate去访问
 */
public interface AccountService {
    int add(Account account);

    int update(Account account);

    int del(int id);

    Account findAccount(int id);

    List<Account> findAccountList();

}
