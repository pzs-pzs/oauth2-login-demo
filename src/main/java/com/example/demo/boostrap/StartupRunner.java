package com.example.demo.boostrap;


import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(value=1)
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... arg0) throws Exception {
        // TODO Auto-generated method stub
        if (userRepository.findUsersByUsername("pzs")==null){
            Role role = new Role("ROLE_USER");
            role = roleRepository.save(role);
            List<Role> list = new ArrayList<>();
            list.add(role);
            User user = new User();
            user.setUsername("pzs");
            user.setPassword(new BCryptPasswordEncoder(4).encode("1234"));
            user.setRoles(list);
            user = userRepository.save(user);
        }

    }
}
