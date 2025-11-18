package com.Projeto.Tca.prisma20.service.turma;

import com.Projeto.Tca.prisma20.model.Turma;

public interface TurmaService {

    public Turma mostrarTurma(Integer turmaId);

    public Turma salvarTurma(Turma turma);
}
