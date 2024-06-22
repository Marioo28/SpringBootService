package com.fdm.service.service;

import com.fdm.service.controller.dto.piesa.CreatePiesaRespDTO;
import com.fdm.service.controller.dto.piesa.ViewPiesaRespDTO;
import com.fdm.service.repository.PiesaRepository;
import com.fdm.service.repository.entity.PiesaEntity;
import com.fdm.service.service.mapper.PiesaMapper;
import com.fdm.service.service.model.Piesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PiesaService {
    private final PiesaRepository piesaRepository;
    private final PiesaMapper piesaMapper;

    public PiesaService(PiesaRepository piesaRepository, PiesaMapper piesaMapper) {
        this.piesaRepository = piesaRepository;
        this.piesaMapper = piesaMapper;
    }

    public CreatePiesaRespDTO createPiesa(Piesa piesaModel) {
        PiesaEntity piesaEntity = piesaMapper.piesaModelToPiesaEntity(piesaModel);
        PiesaEntity piesaEntitySeved = piesaRepository.save(piesaEntity);
        Piesa piesa = piesaMapper.piesaEntityToPiesaModel(piesaEntitySeved);

        return piesaMapper.piesaModelToCreatePiesaRespDTO(piesa);

    }

    public List<ViewPiesaRespDTO> getAllPiese() {
        List<PiesaEntity> piesaEntityList = piesaRepository.findAll();
        List<Piesa> piesaModelList = new ArrayList<>();

        for (PiesaEntity piesaEntity : piesaEntityList) {
            Piesa p = piesaMapper.piesaEntityToPiesaModel(piesaEntity);
            piesaModelList.add(p);
        }
        List<ViewPiesaRespDTO> viewPiesaRespDTOList = new ArrayList<>();

        for (Piesa p : piesaModelList) {
            ViewPiesaRespDTO viewPiesaRespDTO = piesaMapper.piesaModelToViewPiesaRespDTO(p);
            viewPiesaRespDTOList.add(viewPiesaRespDTO);
        }

        return viewPiesaRespDTOList;
    }
}
