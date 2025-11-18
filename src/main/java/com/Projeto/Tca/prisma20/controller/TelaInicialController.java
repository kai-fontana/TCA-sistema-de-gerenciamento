package com.Projeto.Tca.prisma20.controller;


import com.Projeto.Tca.prisma20.service.telainicial.TelaInicialImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/telainicial")
public class TelaInicialController {
    @Autowired
    TelaInicialImpl telaInicialImpl;

    @GetMapping
    public String exibirTurmas(Model model){
        model.addAttribute("turmas", telaInicialImpl.pegarTodasTurmas());
        return "index";
    }

}
