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
        model.addAttribute("turma", turmaImpl.mostrarTurma(turmaIdParam));
        return "turmas";

    }

    @GetMapping("/criarturma")
    public String criarTurma(Model model){
        Turma turma = new Turma();

        model.addAttribute("turma", turma);
        return "cadastroTurmas";
    }

    @PostMapping("/criarturma")
    public String salvarTurma(@ModelAttribute("turma") Turma turma, RedirectAttributes ra){

        turmaImpl.salvarTurma(turma);

        //ra.addFlashAttribute("mensagemSucesso", "Turma criada com sucesso!");

        //redirect: salva os dados e recarrega a página para um novo endereço "/criar-turma", deixando de lado o salvamento recém feito
        return "redirect:/telainicial/criarturma";
    }
}
