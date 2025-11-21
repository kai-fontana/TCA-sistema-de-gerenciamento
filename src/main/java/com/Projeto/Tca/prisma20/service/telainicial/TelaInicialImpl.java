package com.Projeto.Tca.prisma20.service.telainicial;

import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelaInicialImpl implements TelaInicialService {
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<Turma> pegarTodasTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        return turmas;
    }
}
