package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "educandos")
public class Educando {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private int idade;
    @ManyToOne
    private Turma turma;
    private String observacoes;

}
