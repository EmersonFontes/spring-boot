package com.topicos.atividade2.repository;

import com.topicos.atividade2.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {


}
