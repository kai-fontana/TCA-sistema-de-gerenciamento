package com.Projeto.Tca.prisma20.repository;

import com.Projeto.Tca.prisma20.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
