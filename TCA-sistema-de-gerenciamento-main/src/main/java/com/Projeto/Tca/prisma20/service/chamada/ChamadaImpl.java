package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Chamada;
import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.ChamadaRepository;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import com.Projeto.Tca.prisma20.repository.TurmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class ChamadaImpl implements ChamadaService{
    @Autowired
    ChamadaRepository chamadaRepository;

    @Autowired
    EducandoRepository educandoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Transactional
    public void salvarChamada(Long turmaId, Map<String, String> statusPresencaMap) {

        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));

        LocalDate hoje = LocalDate.now();

        for (Map.Entry<String, String> entry : statusPresencaMap.entrySet()) {

            String chaveComPrefixo = entry.getKey();
            String valorString = entry.getValue();

            Long educandoId;
            try {

                educandoId = Long.parseLong(chaveComPrefixo.replaceAll("[^0-9]", ""));
            } catch (NumberFormatException e) {

                continue;
            }

            Boolean status = Boolean.parseBoolean(valorString);

            Educando educando = educandoRepository.findById(educandoId)
                    .orElseThrow(() -> new RuntimeException("Educando não encontrado: " + educandoId));

            Chamada item = new Chamada();
            item.setDataChamada(hoje);
            item.setEducando(educando);
            item.setTurma(turma);
            item.setPresente(status);

            chamadaRepository.save(item);
        }
    }

}