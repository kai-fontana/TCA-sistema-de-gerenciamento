package com.Projeto.Tca.prisma20.controller;
import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.service.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller


public class Controller {
    @Autowired
    LoginImpl loginimpl;


    @GetMapping("/home")
    public String home(){

        return "home";
    }

public String criarLogin(Model model){

    Login login = new Login();
model.addAttribute("login",login);
loginimpl.salvarLogin(login);

return "create-login";

    }



}