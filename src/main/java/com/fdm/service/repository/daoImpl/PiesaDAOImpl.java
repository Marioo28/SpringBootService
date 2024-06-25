package com.fdm.service.repository.daoImpl;

import com.fdm.service.repository.PiesaRepository;
import com.fdm.service.repository.entity.PiesaEntity;
import com.fdm.service.service.dao.PiesaDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PiesaDAOImpl implements PiesaDAO {

    private final PiesaRepository piesaRepository;

    public PiesaDAOImpl(PiesaRepository piesaRepository) {
        this.piesaRepository = piesaRepository;
    }

    @Override
    public PiesaEntity save(PiesaEntity piesaEntity) {
        return piesaRepository.save(piesaEntity);
    }

    @Override
    public List<PiesaEntity> findAll() {
        return piesaRepository.findAll();
    }

    @Override
    public Optional<PiesaEntity> findById(Integer piesaId) {
        return piesaRepository.findById(piesaId);
    }

    @Override
    public void deleteById(Integer piesaId) {
        piesaRepository.deleteById(piesaId);
    }
}
