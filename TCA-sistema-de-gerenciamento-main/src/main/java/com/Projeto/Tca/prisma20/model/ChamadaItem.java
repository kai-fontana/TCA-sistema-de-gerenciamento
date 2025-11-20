package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chamada_item")
public class ChamadaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String presenca;
    @ManyToOne
    private Educando educando;
    @ManyToOne
    private Chamada chamada;

}