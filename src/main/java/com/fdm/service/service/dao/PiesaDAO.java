package com.fdm.service.service.dao;

import com.fdm.service.repository.entity.PiesaEntity;

import java.util.List;
import java.util.Optional;

public interface PiesaDAO {

    PiesaEntity save(PiesaEntity piesaEntity);

    List<PiesaEntity> findAll();

    Optional<PiesaEntity> findById(Integer piesaId);

    void deleteById(Integer piesaId);
}
