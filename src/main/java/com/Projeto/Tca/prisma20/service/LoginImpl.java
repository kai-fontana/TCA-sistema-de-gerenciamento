package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LoginImpl implements LoginService {


    @Autowired
    LoginRepository loginRepository;


    @Override
    public Login salvarLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public boolean emailExiste(String emailLogin) {
        return loginRepository.existsByEmail(emailLogin);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        Optional<Login> loginOpt = loginRepository.findByEmail(email);

        if(loginOpt.isPresent()){
            return senha.equals(loginOpt.get().getSenha());
        } else {
            return false;
        }
    }


}
