package com.Projeto.Tca.prisma20.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Entity
@Table(name = "cursos")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String turno;
    @Column(name = "educador_regente")
    private String educadorRegente;
    @Column(name = "lista_turma")
    @OneToMany(mappedBy = "turma")
    private List<Educando> listaTurma;

}
