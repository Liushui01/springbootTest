package com.example.springboot2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;
}
