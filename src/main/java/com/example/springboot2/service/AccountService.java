package com.example.springboot2.service;

import com.example.springboot2.bean.Account;
import com.example.springboot2.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getacctByid(Long id){
        return accountMapper.getAcc(id);
    }
}
