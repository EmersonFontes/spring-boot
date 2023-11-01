package com.topicos.atividade2.controller;

import com.topicos.atividade2.model.User;
import com.topicos.atividade2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository){

        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getAll (){

        return userRepository.findAll();
    }


}
