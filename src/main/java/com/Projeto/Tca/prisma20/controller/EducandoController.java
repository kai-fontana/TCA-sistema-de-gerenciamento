package com.Projeto.Tca.prisma20.controller;



import com.Projeto.Tca.prisma20.model.Educando;
import com.Projeto.Tca.prisma20.service.EducandoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/listaEducandos")
public class EducandoController {

    @Autowired
    private EducandoImpl educandoImpl;

    @GetMapping
    public String listarEducandos(Model model){

        model.addAttribute("listaEducandos",educandoImpl.pegarEducandosPorTurma());


   return "listar-educandos";

    }
    @GetMapping("/criarEducando")
    public String criarEducando(Model model){
        Educando educando = new Educando();

        model.addAttribute("educando" , educando);
        return "criar-educando";
    }

    @PostMapping("/criarEducando")
    public String salvarEducando(@ModelAttribute("educando")Educando educando){

        educandoImpl.salvarEducando(educando);

        return "redirect:/listaeducandos";
    }

}
