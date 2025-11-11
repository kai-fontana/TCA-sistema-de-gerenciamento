package com.Projeto.Tca.prisma20.service;



import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class loginImpl implements loginService {


    @Autowired
    LoginRepository loginRepository;


    @Override
    public Login salvarLogin(Login login) {
        return loginRepository.save(login);
    }


}
