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
    @Column(name = "data_chamada")
    private LocalDate dataChamada;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
}