package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginImpl implements LoginService {


    @Autowired
    LoginRepository loginRepository;


    @Override
    public Login salvarLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public boolean compararDadosLogin(Login login) {
        return loginRepository.equals();
    }


}
