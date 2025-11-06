package com.Projeto.Tca.prisma20.model;

import lombok.*;

@Data
public class Educando {

    @NonNull
    private String nome;
    @NonNull
    private int idade;
    @NonNull
    private String turma;


    private int id;

    private String cursos;

    private String observacoes;


}
