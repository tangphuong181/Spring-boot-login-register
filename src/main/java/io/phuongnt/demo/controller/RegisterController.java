package io.phuongnt.demo.controller;

import io.phuongnt.demo.dao.RoleRepository;
import io.phuongnt.demo.entity.Role;
import io.phuongnt.demo.entity.User;
import io.phuongnt.demo.service.UserService;
import io.phuongnt.demo.webEntity.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Collection;



@Controller
@RequestMapping("/register")
public class RegisterController {

    UserService userService;

    RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository){

        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("register-form")
   public String register( Model model){
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);

        return "register-form";
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute RegisterUser registerUser,
                           BindingResult result, Model model,
                          HttpSession httpsession){
           String username = registerUser.getUsername();
           if(result.hasErrors()){

             // model.addAttribute("registerUser",registerUser);
               return "register-form";
           }
           User user = userService.findByUsername(username);
           if(user !=null){

             //  model.addAttribute("registerUser", new RegisterUser() );
               model.addAttribute("myError", "Username existed, please chose another username");
              return "register-form";
           }
           else{

              User user1 = new User();


              //Thêm Role mặc định cho tài khoản mới

               Role r1 = roleRepository.findByName("ROLE_USER");
               Collection<Role> role1 = new ArrayList<>();
                role1.add(r1);

                // Xử lý user hợp lệ:

               BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
              user1.setUsername(registerUser.getUsername());
              user1.setPassword(bCrypt.encode(registerUser.getPassword()));
              user1.setFirstname(registerUser.getFirstname());
              user1.setLastname(registerUser.getLastname());
              user1.setEmail(registerUser.getEmail());
              user1.setRoles(role1);
              userService.save(user1);


           httpsession.setAttribute("myuser",user1);

        return "register-success";

    }
    }

}
