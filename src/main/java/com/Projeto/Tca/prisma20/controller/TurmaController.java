package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.service.turma.TurmaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/turmas")
@SessionAttributes("turmaSelecionadaId")
public class TurmaController {
    @Autowired
    TurmaImpl turmaImpl;

    @GetMapping
    public String exibirTurma(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){
        model.addAttribute("listaTurmas", turmaImpl.listarTurmas());

        return "turmas";

    }

    @GetMapping("/novaTurma")
    public String criarTurma(Model model){
        Turma turma = new Turma();

        model.addAttribute("turma", turma);
        return "cadastro-turmas";
    }

    @PostMapping
    public String salvarTurma(@ModelAttribute("turma") Turma turma){

        try {
            turmaImpl.salvarTurma(turma);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/turmas/novaTurma";
        }

        return "redirect:/turmas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarTurma(@PathVariable("id") Long id) {
        turmaImpl.deletarTurma(id);

        return "redirect:/turmas";
    }

    @GetMapping("/editar/{id}")
    public String editarTurma(@PathVariable(name = "id") Long idTurma, Model model){
        Turma turma = turmaImpl.acharTurmaPorId(idTurma);
        model.addAttribute("turma", turma);

        return "redirect:/turmas";
    }
}
