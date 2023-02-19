package com.example.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layouts")
public class LayoutsController {

    @GetMapping("/blank_page")
    public String toblank(){

        return "layouts/blank_page";
    }

    @GetMapping("/boxed_view")
    public String toboxed(){

        return "layouts/boxed_view";
    }

    @GetMapping("/leftmenu_collapsed_view")
    public String tocoll(){

        return "layouts/leftmenu_collapsed_view";
    }

    @GetMapping("/horizontal_menu")
    public String tohor(){

        return "layouts/horizontal_menu";
    }
}
