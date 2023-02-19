package com.example.springboot2.controller;

import com.example.springboot2.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表单内容的遍历
        List<User> users = Arrays.asList(new User("liushui", "123456"),
                new User("liubing", "12344"),
                new User("nihao", "qwert"),
                new User("liaofei", "asdafdfd"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
