package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.service.chamada.ChamadaImpl;
import com.Projeto.Tca.prisma20.service.educando.EducandoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

        if (turmaIdParam != null || turmaIdParam != 0) {
            model.addAttribute("turmaSelecionadaId", turmaIdParam);

            model.addAttribute("listaEducandos", educandoImpl.pegarEducandosPorTurma(turmaIdParam));
        }

        return "chamada";
    }

   /*@PostMapping("/salvar")
    public String salvarChamada(@ModelAttribute("turmaSelecionadaId") Long turmaId, @RequestParam Map<String, String> statusPresencaMap){
        try {
            if (turmaId == null ||  turmaId == 0){

                return "redirect:/chamada";
            }


            chamadaImpl.salvarChamada(turmaId, statusPresencaMap);

        } catch (Exception e) {
            e.printStackTrace();
            // Retorna para a página de chamada, talvez com uma mensagem de erro
            return "redirect:/chamada?turmaId=" + turmaId;
        }

        // Após salvar, redireciona para a lista da turma (ou para uma tela de sucesso)
        return "redirect:/chamada?turmaId=" + turmaId;
    }*/
}