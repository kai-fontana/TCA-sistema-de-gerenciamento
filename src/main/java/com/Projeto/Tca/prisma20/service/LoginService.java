package com.Projeto.Tca.prisma20.service;

import com.Projeto.Tca.prisma20.model.Login;

public interface LoginService {

    public Login salvarLogin(Login login);

    public boolean emailExiste(String emailLogin);

    public boolean autenticar(String email, String senha);
}
