package io.phuongnt.demo.service;

import io.phuongnt.demo.dao.RoleRepository;
import io.phuongnt.demo.dao.UserRepository;
import io.phuongnt.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.phuongnt.demo.entity.Role;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    public UserRepository userrepository;

    public RoleRepository rolerepository;

    @Autowired
    public UserServiceImpl(UserRepository userrepository, RoleRepository rolerepository, BCryptPasswordEncoder passwordEncoder) {
        this.userrepository = userrepository;
        this.rolerepository = rolerepository;
        this.passwordEncoder = passwordEncoder;
    }


//    @PostConstruct
//    public void createUser(){
//        User user1 = new User();
//        user1.setUsername("minhduc");
//        String rawPassword = "123456";
//        user1.setPassword(passwordEncoder.encode(rawPassword));
//        Role r1 = new Role();
//        r1.setName("ROLE_ADMIN");
//        Collection<Role> role1 = new ArrayList<>();
//        role1.add(r1);
//
//        user1.setRoles(role1);
//        userrepository.save(user1);
//
//    }

    @Override
    public User findByUsername(String username) {

        return userrepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userrepository.findByUsername(username);
        System.out.println(" User tìm thấy là" + user.toString());
        if (user==null){

            throw new UsernameNotFoundException("Invalid username ");
        }

        else

            return
                // phải viết dài vì nó trùng User của Entity.
                    new org.springframework.security.core.userdetails
                            .User(user.getUsername(),user.getPassword(),rolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){

        return roles.stream().map(role->new
                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    @Override
    public void save(User user) {

        userrepository.save(user);

    }
}
