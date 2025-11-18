package com.Projeto.Tca.prisma20.controller;

import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.service.educando.EducandoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/educandos")
@SessionAttributes("turmaSelecionadaId")
public class EducandoController {

    @Autowired
    private EducandoImpl educandoImpl;

    @GetMapping
    public String listarEducandos(Model model, @RequestParam(value = "turmaId", required = false) Integer turmaIdParam){
        model.addAttribute("listaEducandos", educandoImpl.pegarEducandosPorTurma(turmaIdParam));

        return "educandos";
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
