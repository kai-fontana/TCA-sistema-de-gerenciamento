package com.Projeto.Tca.prisma20.service.login;

import com.Projeto.Tca.prisma20.model.Login;
import com.Projeto.Tca.prisma20.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginImpl implements LoginService {


    @Autowired
    private LoginRepository loginRepository;

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
