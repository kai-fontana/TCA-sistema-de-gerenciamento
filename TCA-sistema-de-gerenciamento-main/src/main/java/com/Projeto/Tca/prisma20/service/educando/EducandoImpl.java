package com.Projeto.Tca.prisma20.service.educando;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.repository.EducandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class EducandoImpl implements EducandoService {

    @Autowired
    private EducandoRepository educandoRepository;

    @Override
    public List<Educando> pegarEducandosPorTurma(Integer turmaId) {
        return educandoRepository.findByTurma_Id(turmaId);
    }


    private static final String ATUALIZAR_DIR = "src/main/resources/static/images/";

    public void salvarEducando(Educando educando, MultipartFile file) throws Exception {
if (file != null && !file.isEmpty()) {

    String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    Path caminhoDestino = Paths.get(ATUALIZAR_DIR, nomeArquivo);
    Files.copy(file.getInputStream(), caminhoDestino, StandardCopyOption.REPLACE_EXISTING);
    String caminhoPublico = "/images/" + nomeArquivo;
    educando.setCaminhoImagem(caminhoPublico);



} /*else if (educando.getId() != 0) {
    Educando educandoExistente = educandoRepository.findById(educando.getId())
            .orElseThrow(() -> new Exception("Produto não encontrado"));

    educando.setCaminhoImagem(educandoExistente.getCaminhoImagem());
}*/

        educandoRepository.save(educando);
    }

    public Educando escolherEducando(String nomeEducando){
        return educandoRepository.findByNome(nomeEducando);

    }

    @Override
    public void deletarEducando(Educando educando) {
        educandoRepository.delete(educando);
    }
}
