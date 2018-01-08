package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(4);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            System.out.println(s);
            User user = userRepository.findUsersByUsername(s);
            if(user == null){
                throw new UsernameNotFoundException("用户名不存在");
            }
            System.out.println("登录成功");
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return user;
//            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        System.out.println(s);
//        return new org.springframework.security.core.userdetails.User("pzs","1234",authorities);
    }

    public User registryUser(User user){
        User u = userRepository.findUsersByUsername(user.getUsername());
        if (u == null){
            Role role = roleRepository.findByName("ROLE_USER");
            List<Role> list = new ArrayList<>();
            list.add(role);
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(ENCODER.encode(user.getPassword()));
            user1.setRoles(list);
            return  userRepository.save(user1);
        }
        return null;
    }

    public User registryAdmin(User user){
        User u = userRepository.findUsersByUsername(user.getUsername());
        if (u == null){
            Role role = roleRepository.findByName("ROLE_ADMIN");
            List<Role> list = new ArrayList<>();
            list.add(role);
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(ENCODER.encode(user.getPassword()));
            user1.setRoles(list);
            return  userRepository.save(user1);
        }
        return null;
    }
}
