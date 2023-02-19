package com.example.springboot2.dao;

import com.example.springboot2.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getByid(Long id);
}
