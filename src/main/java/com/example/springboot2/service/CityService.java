package com.example.springboot2.service;

import com.example.springboot2.bean.City;
import com.example.springboot2.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;
    public City getByid(Long id){
        return cityMapper.getByid(id);
    }
}
