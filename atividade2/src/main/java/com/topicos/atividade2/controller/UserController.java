package com.topicos.atividade2.controller;

import com.topicos.atividade2.model.Departament;
import com.topicos.atividade2.model.User;
import com.topicos.atividade2.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository){

        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getAll(){

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id){

        if(userRepository.existsById(id)){
            return userRepository.findById(id);
        }else{
            return null;
        }
    }
    @PostMapping
    public Long save(@RequestBody User user){

        userRepository.save(user);

        return user.getId();
    }

    @PutMapping("/{id}")
    public User alter (@PathVariable Long id, @RequestBody  User user){

        if(userRepository.existsById(id)){
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Sucesso";
        }else{
            return "Falha";
        }
    }


}
