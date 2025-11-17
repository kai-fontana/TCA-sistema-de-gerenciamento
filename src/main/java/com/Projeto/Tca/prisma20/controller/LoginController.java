package com.Projeto.Tca.prisma20.controller;
import com.Projeto.Tca.prisma20.model.RequisicaoLogin;
import com.Projeto.Tca.prisma20.service.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginImpl loginimpl;


    @GetMapping("/login")
    public String fazerLogin(Model model){
        RequisicaoLogin reqLogin = new RequisicaoLogin();

        model.addAttribute("reqLogin", reqLogin);
        return "login";
    }

    @PostMapping("/login")
    public String compararLogin(@ModelAttribute("reqLogin") RequisicaoLogin loginReq){
        String compararEmail = loginReq.getEmailReq();
        String compararSenha = loginReq.getSenhaReq();

        if (loginimpl.autenticar(compararEmail, compararSenha)){
            //session.setAttribute("usuarioLogado", loginReq.getEmailReq());
            return "redirect:/telainicial";
        } else {
            //model.addAttribute("erroLogin", "E-mail ou senha inválidos.");
            //return "fazer-login";
            return "redirect:/login";
        }
    }
}