package com.example.springboot2;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit5测试类")
public class Junit5Test {
    @DisplayName("测试方法")
    @Test
    void junittest(){
        System.out.println(1);
    }

    @DisplayName("组合断言")
    @Test
    void wll(){
        assertAll("断言测试",
                ()->assertEquals("123","13","字符串不相等"),
                ()->assertTrue(true));
    }

    @DisplayName("测试断言")
    @Test
    void test2(){
        int i=2+3;
        assertEquals(4,i,"业务逻辑计算失败");
    }



    @DisplayName("超时断言")
    @Test
    void timeOut(){

    }

    @Test
    void testassumptions(){
        Assumptions.assumeTrue(false);
        System.out.println(11111);
    }
}
