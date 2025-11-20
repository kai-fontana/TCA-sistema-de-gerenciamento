package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cadastro")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String senha;


}

//    private EsqueciSENHA
