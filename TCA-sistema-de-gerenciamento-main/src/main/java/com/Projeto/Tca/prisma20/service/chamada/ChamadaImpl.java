package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Chamada;
import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.ChamadaRepository;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class ChamadaImpl implements ChamadaService{
    @Autowired
    EducandoRepository educandoRepository;

    @Autowired
    ChamadaRepository chamadaRepository;

    public void salvarChamada(Map<Long, String> statusPresenca, Turma turma){
        LocalDate hoje = LocalDate.now();

        for (Map.Entry<Long, String> entry : statusPresenca.entrySet()) {

            Long educandoId = entry.getKey();
            String status = entry.getValue();

            Educando educando = educandoRepository.findById(educandoId).orElseThrow(() -> new RuntimeException("Educando não encontrado"));

            Chamada item = new Chamada();
            item.setDataChamada(hoje);
            item.setEducando(educando);
            item.setTurma(turma);
            item.setPresenca(status);

            chamadaRepository.save(item);
        }

    }

}