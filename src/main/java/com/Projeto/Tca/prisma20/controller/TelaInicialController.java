package com.Projeto.Tca.prisma20.controller;


import com.Projeto.Tca.prisma20.service.telainicial.TelaInicialImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
@SessionAttributes("turmaSelecionadaId")
public class TelaInicialController {

    @Autowired
    TelaInicialImpl telaInicialImpl;

    @GetMapping
    public String exibirTurmas(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){

        if (turmaIdParam != null && turmaIdParam != 0) {
            return "redirect:/educandos";
        }

        try {
            model.addAttribute("turmas", telaInicialImpl.pegarTodasTurmas());
        } catch (Exception e) {
            model.addAttribute("turmas", new java.util.ArrayList<>());
        }

        return "index";

    }

}
