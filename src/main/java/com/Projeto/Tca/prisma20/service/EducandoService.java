package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Educando;

import java.util.List;

public interface EducandoService {

    public List<Educando> pegarEducando();

    public Educando salvarEducando (Educando educando);


}
