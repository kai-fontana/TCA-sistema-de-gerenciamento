package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Data
@Entity
public class Chamada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; private
    LocalDate dataChamada;
    @ManyToOne
    @JoinColumn(name = "educando_id")
    private Educando educando;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @Column(nullable = false)
    private String presenca;
}