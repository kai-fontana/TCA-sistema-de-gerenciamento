package com.Projeto.Tca.prisma20.repository;

import com.Projeto.Tca.prisma20.model.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Integer> {
}