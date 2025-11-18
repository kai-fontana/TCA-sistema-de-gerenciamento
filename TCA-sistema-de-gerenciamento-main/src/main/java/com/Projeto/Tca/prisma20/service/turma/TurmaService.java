package com.Projeto.Tca.prisma20.service.turma;

import com.Projeto.Tca.prisma20.model.Turma;

import java.util.Optional;

public interface TurmaService {

    public Optional<Turma> mostrarTurma(Integer turmaId);

    public Turma salvarTurma(Turma turma);
}
