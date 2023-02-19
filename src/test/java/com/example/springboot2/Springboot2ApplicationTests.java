package com.example.springboot2;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Springboot2ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        log.info("记录数:{}",aLong);
        log.info("数据源的类型:{}",dataSource.getClass());
    }

    @Test
    public void get(){
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("hello","llll");
        String hello = stringStringValueOperations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}
