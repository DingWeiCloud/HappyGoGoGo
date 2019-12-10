package com.happy.boot.controller;

import com.happy.boot.entity.Account;
import com.happy.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : <a href="mailto:dingweicloud@163.com">dingweixie</a>
 * @version : v1.0
 * @date :  2019/12/10  20:34
 * @description :springboot通过jdbc访问关系型mysql,通过spring的JdbcTemplate去访问
 */
@RestController
@RequestMapping("/account")
public class AccountController {
@Autowired
    AccountService accountService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t= accountService.add(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }

    }
}
