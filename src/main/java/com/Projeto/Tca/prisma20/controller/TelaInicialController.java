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
    private static final Logger logger = LoggerFactory.getLogger(TelaInicialController.class);

    @Autowired
    TelaInicialImpl telaInicialImpl;

    @GetMapping
    public String exibirTurmas(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){

        if (turmaIdParam != null && turmaIdParam != 0) {
            model.addAttribute("turmaSelecionadaId", turmaIdParam);
            return "redirect:/educandos";
        }

        try {
            logger.info("Carregando todas as turmas...");
            model.addAttribute("turmas", telaInicialImpl.pegarTodasTurmas()); // <--- A falha está provavelmente aqui!
            logger.info("Turmas carregadas com sucesso. Renderizando view 'index'.");
        } catch (Exception e) {
            logger.error("ERRO ao carregar turmas para a página inicial: {}", e.getMessage(), e);
            model.addAttribute("turmas", new java.util.ArrayList<>()); // Evita quebra do Thymeleaf
        }

        return "index";

    }

}
