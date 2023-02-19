package com.example.springboot2.controller;

import com.example.springboot2.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName())&&StringUtils.length(user.getPassword())!=0){
            session.setAttribute("loginUser",user);
            return "redirect:/index";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }

    @GetMapping("/index")
    public String toindex(HttpSession session,Model model){
        return "index";
    }

    @GetMapping("/index_alt")
    public String toindex_alt(HttpSession session,Model model){
        Object loginUser =session.getAttribute("loginUser");
        if(loginUser!=null){
            return "index_alt";
        }else{
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public Long getsql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return aLong;
    }
}
