package com.happy.boot.service.impl;

import com.happy.boot.dao.AccountDao;
import com.happy.boot.entity.Account;
import com.happy.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  20:31
 * @description : springboot通过jdbc访问关系型mysql,通过spring的JdbcTemplate去访问
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int del(int id) {
        return accountDao.del(id);
    }

    @Override
    public Account findAccount(int id) {
        return accountDao.findAccount(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}
