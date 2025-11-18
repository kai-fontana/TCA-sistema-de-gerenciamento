package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.service.chamada.ChamadaImpl;
import com.Projeto.Tca.prisma20.service.educando.EducandoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chamada")
@SessionAttributes("turmaSelecionadaId")
public class ChamadaController {
    @Autowired
    private EducandoImpl educandoImpl;

    @Autowired
    private ChamadaImpl chamadaImpl;

    @GetMapping
    public String exibirChamada(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){
        if (turmaIdParam != null && turmaIdParam != 0) {
            model.addAttribute("listaEducandos", educandoImpl.pegarEducandosPorTurma(turmaIdParam));
        }

        return "chamada";
    }

}
