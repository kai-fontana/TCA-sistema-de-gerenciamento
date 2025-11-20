package com.Projeto.Tca.prisma20.service.chamada;


import java.util.Map;

public interface ChamadaService {
    public void salvarChamada(Long turmaId, Map<String, String> statusPresencaMap);
}