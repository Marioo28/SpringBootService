package com.fdm.service.repository;

import com.fdm.service.repository.entity.PiesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PiesaRepository extends JpaRepository<PiesaEntity, Integer> {
}
