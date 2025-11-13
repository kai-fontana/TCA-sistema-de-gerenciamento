package com.Projeto.Tca.prisma20.controller;


import com.Projeto.Tca.prisma20.model.Turma;
import com.Projeto.Tca.prisma20.service.TurmaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/telainicial")
public class TurmaController {
    @Autowired
    TurmaImpl turmaImpl;

    @GetMapping
    public String exibirTurmas(Model model){
        model.addAttribute("turmas", turmaImpl.pegarTodasTurmas());
        return "telaInicial";
    }

    @GetMapping("/criarturma")
    public String criarTurma(Model model){
        Turma turma = new Turma();

        model.addAttribute("turma", turma);
        return "criar-turma";
    }

    @PostMapping("/criarturma")
    public String salvarTurma(@ModelAttribute("turma") Turma turma, RedirectAttributes ra){

        turmaImpl.salvarTurma(turma);

        //ra.addFlashAttribute("mensagemSucesso", "Turma criada com sucesso!");

        //redirect: salva os dados e recarrega a página para um novo endereço "/criar-turma", deixando de lado o salvamento recém feito
        return "redirect:/telainicial/criarturma";
    }

}
