package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.model.Educando;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller


public class Controller {
    @GetMapping("/home")
    public String home(){

        return "home";
    }

public String criarEducando(Model model){

    Educando educando = new Educando();
model.addAttribute("educando",educando);

return "create-educando";

    }



}