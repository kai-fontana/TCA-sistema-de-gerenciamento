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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ChamadaImpl implements ChamadaService{

    private static final Logger logger = LoggerFactory.getLogger(ChamadaImpl.class);

    @Autowired
    ChamadaItemRepository chamadaItemRepository;

    @Autowired
    ChamadaRepository chamadaRepository;

    @Autowired
    EducandoRepository educandoRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @Transactional
    @Override
    public void salvarChamada(Long turmaId, String dataChamadaStr, Map<String, String> statusPresencaMap) {


        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada! ID: " + turmaId));

        LocalDate dataChamada = (dataChamadaStr != null && !dataChamadaStr.isEmpty())
                ? LocalDate.parse(dataChamadaStr)
                : LocalDate.now();

        Chamada chamada = new Chamada();
        chamada.setDataChamada(dataChamada);
        chamada.setTurma(turma);

        Chamada chamadaSalva = chamadaRepository.save(chamada);


        for (Map.Entry<String, String> entry : statusPresencaMap.entrySet()) {

            String chave = entry.getKey();
            String status = entry.getValue();

            if (chave.equals("turmaSelecionadaId") || chave.equals("dataChamada") || !chave.startsWith("presenca_") || status.isEmpty()) {
                continue;
            }

            Long educandoId;
            try {
                educandoId = Long.parseLong(chave.substring("presenca_".length()));
            } catch (NumberFormatException e) {
                continue;
            }


            Educando educando = educandoRepository.findById(educandoId)
                    .orElseThrow(() -> new RuntimeException("Educando não encontrado: " + educandoId));

            if ("P".equalsIgnoreCase(status)){

                educando.setQuantidadePresencas(educando.getQuantidadePresencas() + 1);
                educandoRepository.save(educando);
            }


            ChamadaItem item = new ChamadaItem();
            item.setPresenca(status);
            item.setEducando(educando);

            item.setChamada(chamadaSalva);

            chamadaItemRepository.save(item);
        }
    }

}