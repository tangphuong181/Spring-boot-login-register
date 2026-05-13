package io.phuongnt.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping({"/","/home"})

    public String showHomePage(Model mode){

        return "home";
    }

    @GetMapping("/public/**")

    public String index(){

        return "public/index";
    }



}
