package com.example.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/forms")
public class FormController {



    /**
     * MultipartFile自动封装上传过来的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {

        if(!headerImg.isEmpty()){
            //保存到文件服务器，oss服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\浏览器下载\\"+originalFilename));
        }
        if(photos.length>0){
            for(MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\浏览器下载\\"+originalFilename));
                }
            }
        }
        return "form/form_layouts";
    }

    @GetMapping("/form_layouts")
    public String toform_layouts(){
        return "form/form_layouts";
    }

    @GetMapping("/form_advanced_components")
    public String toform_advanced_components(){

        return "form/form_advanced_components";
    }

    @GetMapping("/form_wizard")
    public String toform_wizard(){

        return "form/form_wizard";
    }

    @GetMapping("/form_validation")
    public String toform_validation(){

        return "form/form_validation";
    }

    @GetMapping("/editors")
    public String toeditors(){

        return "form/editors";
    }

    @GetMapping("/inline_editors")
    public String toinline_editors(){

        return "form/inline_editors";
    }
    @GetMapping("/pickers")
    public String topickers(){

        return "form/pickers";
    }
    @GetMapping("/dropzone")
    public String todropzone(){

        return "form/dropzone";
    }
}
