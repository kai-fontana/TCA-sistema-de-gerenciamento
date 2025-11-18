package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Chamada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private final LocalDate dataAtual = LocalDate.now();
    private Turma turma;

}
