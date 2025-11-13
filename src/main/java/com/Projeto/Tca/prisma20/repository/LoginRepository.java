package com.Projeto.Tca.prisma20.repository;

import com.Projeto.Tca.prisma20.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    boolean existsByEmail(String email);

    Optional<Login> findByEmail(String email);

    Optional<Login> findBySenha(String senha);


}
