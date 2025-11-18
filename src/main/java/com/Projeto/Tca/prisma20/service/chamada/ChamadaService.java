package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Educando;

public interface ChamadaService {
    public Educando escolherEducando(String nomeEducando);

    public void deletarEducando(Educando educando);
}
