package com.Projeto.Tca.prisma20.service.chamada;

import java.util.Map;

public interface ChamadaService {

    void salvarChamada(Long turmaId, String dataChamada, Map<String, String> statusPresencaMap);
}