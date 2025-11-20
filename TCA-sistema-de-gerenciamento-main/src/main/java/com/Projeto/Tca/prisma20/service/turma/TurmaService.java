package com.Projeto.Tca.prisma20.service.turma;

import com.Projeto.Tca.prisma20.model.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaService {

    Optional<Turma> mostrarTurma(Integer turmaId);

    Turma salvarTurma(Turma turma);

    Optional<Turma> mostrarTurma(Long turmaId);

    List<Turma> listarTurmas();

    void deletarTurma(long id);

    Turma acharTurmaPorId(Long idTurma);
}
