package com.topicos.atividade2.controller;

import com.topicos.atividade2.model.Departament;
import com.topicos.atividade2.repository.DepartamentRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Departament> getById(@PathVariable Long id){

        if(departamentRepository.existsById(id)){
            return departamentRepository.findById(id);
        }else{
            return null;
        }
    }
    @PostMapping
    public Long save(@RequestBody Departament departament){

        departamentRepository.save(departament);

        return departament.getId();
    }

    @PutMapping("/{id}")
    public Departament alter (@PathVariable Long id, @RequestBody  Departament departament){

        if(departamentRepository.existsById(id)){
            return departamentRepository.save(departament);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        if(departamentRepository.existsById(id)){
            departamentRepository.deleteById(id);
            return "Sucesso";
        }else{
            return "Falha";
        }
    }

}
