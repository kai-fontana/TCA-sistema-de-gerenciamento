package com.Projeto.Tca.prisma20.repository;

import com.Projeto.Tca.prisma20.model.Educando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducandoRepository extends JpaRepository<Educando, Integer> {
    List<Educando> findByTurma_Id(Integer turmaId);
}
