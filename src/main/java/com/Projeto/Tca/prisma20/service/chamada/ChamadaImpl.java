package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadaImpl implements ChamadaService{
    @Autowired
    EducandoRepository educandoRepository;

    public Educando escolherEducando(String nomeEducando){
        return educandoRepository.findByNome(nomeEducando);

    }

    @Override
    public void deletarEducando(Educando educando) {
        educandoRepository.delete(educando);
    }
}