package com.happy.boot.dao.impl;

import com.happy.boot.dao.AccountDao;
import com.happy.boot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  20:16
 * @description :springboot通过jdbc访问关系型mysql,通过spring的JdbcTemplate去访问
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert  into  account (name, money) values (?,?)", account.getName(), account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE  account SET NAME=? ,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int del(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }

    @Override
    public Account findAccount(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            Account account = list.get(0);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
