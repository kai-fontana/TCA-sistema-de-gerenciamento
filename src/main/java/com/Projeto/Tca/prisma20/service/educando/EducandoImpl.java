package com.Projeto.Tca.prisma20.service.educando;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.transaction.Transactional; // Adicionar se não estiver presente

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class EducandoImpl implements EducandoService {

    @Autowired
    private EducandoRepository educandoRepository;

    @Override
    public List<Educando> pegarEducandosPorTurma(Integer turmaId) {

        if (turmaId == null || turmaId == 0) {
            return educandoRepository.findAll();
        }
        return educandoRepository.findByTurma_Id(turmaId);
    }

    private static final String ATUALIZAR_DIR = "src/main/resources/static/images/";

    @Transactional
    public void salvarEducando(Educando educando, MultipartFile file) throws Exception {
        String caminhoImagemExistente = null;

        if (educando.getId() != null) {
            Optional<Educando> educandoExistente = educandoRepository.findById(educando.getId());
            if (educandoExistente.isPresent()) {
                caminhoImagemExistente = educandoExistente.get().getCaminhoImagem();

                educando.setQuantidadePresencas(educandoExistente.get().getQuantidadePresencas());
                educando.setAssiduidade(educandoExistente.get().getAssiduidade());
                educando.setObservacoes(educandoExistente.get().getObservacoes());
            }
        }

        if (file != null && !file.isEmpty()) {

            String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path caminhoDestino = Paths.get(ATUALIZAR_DIR, nomeArquivo);

            Files.createDirectories(caminhoDestino.getParent());

            Files.copy(file.getInputStream(), caminhoDestino, StandardCopyOption.REPLACE_EXISTING);

            String caminhoPublico = "/images/" + nomeArquivo;
            educando.setCaminhoImagem(caminhoPublico);

        } else if (educando.getId() != null) {

            educando.setCaminhoImagem(caminhoImagemExistente);
        }
        
        educandoRepository.save(educando);
    }


    @Override
    public void deletarEducando(long id) {
        educandoRepository.deleteById(id);
    }

    @Override
    public Educando acharEducandoPorId(Long idEducando) {
        return educandoRepository.findById(idEducando)
                .orElseThrow(() -> new RuntimeException("Educando não encontrado com ID: " + idEducando));
    }
}