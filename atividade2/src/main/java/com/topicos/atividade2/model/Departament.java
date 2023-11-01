package com.topicos.atividade2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_departament")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    private String name;
    @OneToMany( mappedBy = "departament",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;


}
