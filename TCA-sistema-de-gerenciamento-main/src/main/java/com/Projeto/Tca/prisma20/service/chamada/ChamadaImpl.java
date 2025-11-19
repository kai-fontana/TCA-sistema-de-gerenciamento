package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Chamada;
import com.Projeto.Tca.prisma20.model.ChamadaItem;
import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.repository.ChamadaItemRepository;
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
    ChamadaItemRepository chamadaItemRepository;

    @Autowired
    EducandoRepository educandoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    int dias;
    double porcentagemPresenca;

    @Transactional
    public void salvarChamada(Long turmaId, Map<String, String> statusPresencaMap) {

        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));

        LocalDate hoje = LocalDate.now();

        Chamada chamada = new Chamada();
        chamada.setDataChamada(hoje);
        chamada.setTurma(turma);

        for (Map.Entry<String, String> entry : statusPresencaMap.entrySet()) {

            String chaveComPrefixo = entry.getKey();
            String status = entry.getValue();


            Long educandoId;
            try {

                educandoId = Long.parseLong(chaveComPrefixo);
            } catch (NumberFormatException e) {

                continue;
            }

            Educando educando = educandoRepository.findById(educandoId)
                    .orElseThrow(() -> new RuntimeException("Educando não encontrado: " + educandoId));

            if (status.equalsIgnoreCase("F")){
                educando.setQuantidadePresencas(educando.getQuantidadePresencas() + 1);
            }
            dias++;
            porcentagemPresenca = educando.getQuantidadePresencas() / dias;
            educando.setAssiduidade(porcentagemPresenca);

            ChamadaItem item = new ChamadaItem();
            item.setPresenca(status);
            item.setEducando(educando);
            item.setChamada(chamada);

            chamadaItemRepository.save(item);
        }
    }

}