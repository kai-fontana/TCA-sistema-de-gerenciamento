package com.Projeto.Tca.prisma20.repository;

import com.Projeto.Tca.prisma20.model.ChamadaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadaItemRepository extends JpaRepository<ChamadaItem, Long> {
}