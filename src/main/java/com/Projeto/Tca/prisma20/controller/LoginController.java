package com.Projeto.Tca.prisma20.controller;
import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.model.RequisicaoLogin;
import com.Projeto.Tca.prisma20.service.LoginImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginImpl loginimpl;

    @GetMapping
    public String telaInicial(){

        return "telaInicial";
    }

    @GetMapping("/cadastro")
    public String criarLogin(Model model){

        Login login = new Login();
        model.addAttribute("login",login);

        return "criar-login";

    }

    @PostMapping("/cadastro")
    public String loginExistente(@ModelAttribute("login") Login login, RedirectAttributes ra){
        if (loginimpl.emailExiste(login.getEmail())){
            //ra.addFlashAttribute("erroCadastro", "Este e-mail já está cadastrado.");
            return "redirect:/cadastro";
        } else {
            salvarCadastro(login);
            return "redirect:/login";
        }

    }


    private Login salvarCadastro(@ModelAttribute("login") Login login){
        return loginimpl.salvarLogin(login);
    }


    @GetMapping("/login")
    public String fazerLogin(Model model){
        RequisicaoLogin reqLogin = new RequisicaoLogin();

        model.addAttribute("reqLogin", reqLogin);
        return "fazer-login";
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