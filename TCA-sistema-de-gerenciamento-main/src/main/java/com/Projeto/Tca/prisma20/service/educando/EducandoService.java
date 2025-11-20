package com.Projeto.Tca.prisma20.service.educando;

import com.Projeto.Tca.prisma20.model.Educando;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EducandoService {

    void salvarEducando(Educando educando, MultipartFile file) throws Exception;

    List<Educando> pegarEducandosPorTurma(Integer turmaId);

    Educando escolherEducando(String nomeEducando);

    void deletarEducando(long id);

    Educando acharEducandoPorId(Long idEducando);
}
