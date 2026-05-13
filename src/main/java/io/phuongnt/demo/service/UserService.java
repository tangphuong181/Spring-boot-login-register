package io.phuongnt.demo.service;

import io.phuongnt.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

     public User findByUsername(String username);

     public void save(User user);

}
