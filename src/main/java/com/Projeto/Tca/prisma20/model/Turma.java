package com.Projeto.Tca.prisma20.model;


import lombok.Data;
import java.util.List;


@Data
public class Turma {

    private String nome;
    private String turno;
    private String educadorRegente;
    private List<Educando> listaTurma;
}
