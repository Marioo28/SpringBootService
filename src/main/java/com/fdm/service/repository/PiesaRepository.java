package com.fdm.service.repository;

import com.fdm.service.repository.entity.PiesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiesaRepository extends JpaRepository<PiesaEntity,Integer> {
}
