package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;

import java.util.List;

public interface EducandoService {

    public List<Educando> pegarEducando();

    public Educando salvarEducando (Educando educando);

    public List<Educando> pegarEducandoPorTurma(Turma turma);


}
