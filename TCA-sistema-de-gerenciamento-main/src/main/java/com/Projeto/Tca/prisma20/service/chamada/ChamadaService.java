package com.Projeto.Tca.prisma20.service.chamada;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.model.Turma;

import java.util.Map;

public interface ChamadaService {
    public void salvarChamada(Map<Long, String> statusPresenca, Turma turma);

}
