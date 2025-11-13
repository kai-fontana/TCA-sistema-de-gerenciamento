package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducandoImpl implements EducandoService{

    @Autowired
    private EducandoRepository educandoRepository;

    @Override
    public List<Educando> pegarEducando() {
        List<Educando> Educando = educandoRepository.findAll();
        return Educando;
    }

    @Override
    public Educando salvarEducando(Educando educando) {
        return educandoRepository.save(educando);
    }

    @Override
    public List<Educando> pegarEducandoPorTurma(Turma turma) {
        return educandoRepository.findByTurma(turma);
    }
}
