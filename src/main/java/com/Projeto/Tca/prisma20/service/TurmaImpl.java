package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TurmaImpl implements TurmaService{
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<Turma> pegarTodasTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        return turmas;
    }

    @Override
    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }
}
