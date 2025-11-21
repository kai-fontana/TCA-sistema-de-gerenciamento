package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.service.chamada.ChamadaImpl;
import com.Projeto.Tca.prisma20.service.educando.EducandoImpl;
import com.Projeto.Tca.prisma20.service.telainicial.TelaInicialImpl; // Adicionado para carregar turmas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Collections; // Importar para lista vazia

@Controller
@RequestMapping("/chamada")
@SessionAttributes("turmaSelecionadaId")
public class ChamadaController {
    @Autowired
    private EducandoImpl educandoImpl;

    @Autowired
    private ChamadaImpl chamadaImpl;

    @Autowired // Injete o serviço que carrega as turmas
    private TelaInicialImpl telaInicialImpl;

    @GetMapping
    public String exibirChamada(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){


        try {
            model.addAttribute("listaTurmas", telaInicialImpl.pegarTodasTurmas());
        } catch (Exception e) {

            model.addAttribute("listaTurmas", Collections.emptyList());
        }

        if (turmaIdParam != null && turmaIdParam != 0) {
            model.addAttribute("turmaSelecionadaId", turmaIdParam);

            model.addAttribute("listaEducandos", educandoImpl.pegarEducandosPorTurma(turmaIdParam));
        } else {

            model.addAttribute("listaEducandos", Collections.emptyList());
        }

        return "chamada";
    }

    @PostMapping("/salvar")
    public String salvarChamada(@ModelAttribute("turmaSelecionadaId") Long turmaId, @RequestParam Map<String, String> statusPresencaMap){
        try {
            if (turmaId == null) {

                return "redirect:/chamada";
            }
            chamadaImpl.salvarChamada(turmaId, statusPresencaMap);

        } catch (Exception e) {
            e.printStackTrace();

            return "redirect:/chamada?turmaId=" + turmaId;
        }

        return "redirect:/chamada?turmaId=" + turmaId;
    }

}