package com.Projeto.Tca.prisma20.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class Educador {

    private String nome;
    private String cargo;
    private LocalDate dataEntrada;
    private LocalDate dataNascimento;


}
