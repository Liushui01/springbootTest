package com.example.springboot2.dao;

import com.example.springboot2.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAcc(Long id);
}
