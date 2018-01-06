package com.example.demo.controller;

import com.example.demo.api.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "login";
    }

    @Qualifier("oauth2ClientContext")
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @GetMapping("/demo")
    @ResponseBody
    public GithubUser demo(){
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(oauth2ClientContext.getAccessToken());
        String url = "https://api.github.com/user?access_token="+oauth2ClientContext.getAccessToken();
        System.out.println(oauth2ClientContext.getAccessToken());
        GithubUser s = restTemplate.getForObject(url,GithubUser.class);
        return s;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "success";
    }




}
