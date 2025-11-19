package com.Projeto.Tca.prisma20.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "educandos")
public class Educando {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    private String email;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @Column(name = "caminho_imagem")
    private String caminhoImagem;
    private int quantidadePresencas;
    private double assiduidade;
    private String observacoes;

}
