package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Turma;

import java.util.List;

public interface TurmaService {
    public List<Turma> pegarTodasTurmas();

    public Turma salvarTurma(Turma turma);
}
