package com.topicos.atividade2.controller;

import com.topicos.atividade2.model.Departament;
import com.topicos.atividade2.repository.DepartamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {

    private final DepartamentRepository departamentRepository;

    public DepartamentController(final DepartamentRepository departamentRepository){
        this.departamentRepository = departamentRepository;
    }
    @GetMapping
    public List<Departament> getAll(){

        return departamentRepository.findAll();
    }

}
