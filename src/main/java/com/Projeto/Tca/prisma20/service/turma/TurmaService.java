package com.Projeto.Tca.prisma20.service.turma;

import com.Projeto.Tca.prisma20.model.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaService {

    Turma salvarTurma(Turma turma);

    List<Turma> listarTurmas();

    void deletarTurma(long id);

    Turma acharTurmaPorId(Long idTurma);
}
