package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.service.EducandoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/listaEducandos")
@SessionAttributes("turmaSelecionadaId")
public class EducandoController {

    @Autowired
    private EducandoImpl educandoImpl;

    @GetMapping
    public String listarEducandos(Model model, @SessionAttribute(name = "turmaSelecionadaId", required = false) Integer turmaIdSelecionada){
        if (turmaIdSelecionada == null) {
            return "redirect:/telainicial";
        }


        model.addAttribute("listaEducandos", educandoImpl.pegarEducandosPorTurma(turmaIdSelecionada));

        return "turmas";
    }


    @GetMapping("/criarEducando")
    public String criarEducando(Model model){
        Educando educando = new Educando();

        model.addAttribute("educando", educando);
        return "cadastroEducandos";
    }

    @PostMapping("/criarEducando")
    public String salvarEducando(@ModelAttribute("educando")Educando educando, @RequestParam(value = "file", required = false) MultipartFile file ){

        try {
            educandoImpl.salvarEducando(educando, file);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/criarEducando";
        }

        return "redirect:/listaeducandos";
    }

}
