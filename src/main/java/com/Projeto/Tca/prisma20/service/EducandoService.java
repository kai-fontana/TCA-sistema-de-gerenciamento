package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EducandoService {

    public void salvarEducando(Educando educando, MultipartFile file) throws Exception;

    public List<Educando> pegarEducandosPorTurma(Integer turmaId);


}
