package com.example.demo.repository;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Test
    public void findUsersByUsername() throws Exception {
//        Role role = new Role("ROLE_USER");
//        role = roleRepository.save(role);
//        List<Role> list = new ArrayList<>();
//        list.add(role);
//        User user = new User();
//        user.setUsername("pzs");
//        user.setPassword("1234");
//        //user.setRoles(list);
//        user = userRepository.save(user);

        User user = userRepository.findUsersByUsername("pzs");
        System.out.println(user);

    }


}