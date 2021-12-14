package com.example.eafinalproject.security.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@PropertySource("classpath:application.properties")
public class UserService implements UserDetailsService {

    @Autowired        // NO LONGER auto-created by Spring Cloud (see below)
   // @LoadBalanced     // Explicitly request the load-balanced template, with Ribbon built-in
    protected RestTemplate restTemplate;

    @Value("${services.account.token}")
    private String accountServiceToken;

    @Value("${services.account.url}")
    private String accountServiceUrl;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        try {
            System.out.println("username: " + s);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("TOKEN", accountServiceToken);
            String responseStr = restTemplate.exchange(accountServiceUrl
                + "/api/account/affiliate/login/{email}",  HttpMethod.GET, new HttpEntity<>(headers), String.class, s)
                    .getBody();
            JsonNode root = objectMapper.readTree(responseStr);
            user = new User(root.path("data").path("email").asText(), root.path("data").path("password").asText(), new ArrayList<>() {
                {
                    add(new SimpleGrantedAuthority("USER"));
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("error: " + e.getMessage());
        }
        System.out.println("username2: " + s);
        return user;
    }
}