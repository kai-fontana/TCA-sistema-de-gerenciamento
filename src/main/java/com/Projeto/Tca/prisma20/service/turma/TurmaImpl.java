package com.Projeto.Tca.prisma20.service.turma;

import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }


    public void deletarTurma(long id) {
        turmaRepository.deleteById(id);
    }

    @Override
    public Turma acharTurmaPorId(Long idTurma) {
        return turmaRepository.findById(idTurma)
                .orElseThrow();
    }


}
