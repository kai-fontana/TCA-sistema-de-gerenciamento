package com.Projeto.Tca.prisma20.controller;
import com.Projeto.Tca.prisma20.model.RequisicaoLogin;
import com.Projeto.Tca.prisma20.service.login.LoginImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginImpl loginimpl;


    @GetMapping("/login")
    public String fazerLogin(Model model){
        logger.debug("Acessando a página de login.");
        RequisicaoLogin reqLogin = new RequisicaoLogin();

        model.addAttribute("reqLogin", reqLogin);
        model.addAttribute("erroLogin", null);
        return "login";
    }

    @PostMapping("/login")
    public String compararLogin(@ModelAttribute("reqLogin") RequisicaoLogin loginReq, Model model){
        String compararEmail = loginReq.getEmailReq();
        String compararSenha = loginReq.getSenhaReq();

        logger.info("Tentativa de login recebida para o email: {}", compararEmail);

        if (loginimpl.autenticar(compararEmail, compararSenha)){
            //session.setAttribute("usuarioLogado", loginReq.getEmailReq());
            logger.info("Login bem-sucedido. Redirecionando para /index.");
            return "redirect:/index";
        } else {
            logger.warn("Login falhou para o email: {}. Credenciais inválidas.", compararEmail);
            model.addAttribute("erroLogin", "E-mail ou senha inválidos. Tente novamente.");
            model.addAttribute("reqLogin", loginReq);
            return "login";
        }
    }
}