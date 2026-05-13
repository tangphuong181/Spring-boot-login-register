package io.phuongnt.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Hiển thị Form đẻ Login vào
    @GetMapping("/showLoginPage")
    public String showLoginPage(){

        return "login";
    }
//
//    @GetMapping("/footer")
//    public String showFooter(){
//
//        return "fragment/footer";
//    }



    @GetMapping("/showPage403")
    public String showPage403(){

        return "error/403";
    }
}
