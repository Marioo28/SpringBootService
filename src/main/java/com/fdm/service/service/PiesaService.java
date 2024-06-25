package com.fdm.service.service;

import com.fdm.service.controller.dto.piesa.CreatePiesaRespDTO;
import com.fdm.service.controller.dto.piesa.GetPiesaRespDTO;
import com.fdm.service.controller.dto.piesa.UpdatePiesaRespDTO;
import com.fdm.service.controller.dto.piesa.ViewPiesaRespDTO;
import com.fdm.service.service.exceptions.piese.PiesaAlreadyExistsException;
import com.fdm.service.service.exceptions.piese.PiesaNotFoundException;
import com.fdm.service.repository.entity.PiesaEntity;
import com.fdm.service.service.dao.PiesaDAO;
import com.fdm.service.service.mapper.PiesaMapper;
import com.fdm.service.service.model.Piesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PiesaService {
    private final PiesaDAO piesaDAO;
    private final PiesaMapper piesaMapper;

    public PiesaService(PiesaDAO piesaDAO, PiesaMapper piesaMapper) {
        this.piesaDAO = piesaDAO;
        this.piesaMapper = piesaMapper;
    }

    public CreatePiesaRespDTO createPiesa(Piesa piesaModel) {
        checkForDuplicate(piesaModel);
        PiesaEntity piesaEntity = piesaMapper.piesaModelToPiesaEntity(piesaModel);
        PiesaEntity piesaEntitySeved = piesaDAO.save(piesaEntity);
        Piesa piesa = piesaMapper.piesaEntityToPiesaModel(piesaEntitySeved);

        return piesaMapper.piesaModelToCreatePiesaRespDTO(piesa);
    }

    public List<ViewPiesaRespDTO> getAllPiese() {
        List<PiesaEntity> piesaEntityList = piesaDAO.findAll();
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

    public UpdatePiesaRespDTO updatePiesa(Integer piesaId, Piesa piesaModel) {
        checkForDuplicate(piesaModel);
        Optional<PiesaEntity> piesaEntityOptional = piesaDAO.findById(piesaId);
        PiesaEntity piesaEntity = piesaEntityOptional.get();
        piesaEntity = piesaMapper.piesaModelToPiesaEntity(piesaModel);
        piesaEntity.setId(piesaId);
        PiesaEntity userEntityUpdate = piesaDAO.save(piesaEntity);
        Piesa piesa = piesaMapper.piesaEntityToPiesaModel(userEntityUpdate);
        return piesaMapper.updatePiesaRespDTO(piesa);
    }

    public void deletePiesa(Integer piesaId) {
        piesaDAO.findById(piesaId)
                .orElseThrow(() -> new PiesaNotFoundException("Piesa cu id " + piesaId + " nu exista"));
        piesaDAO.deleteById(piesaId);
    }

    public GetPiesaRespDTO getPiesaById(int piesaId) {
        PiesaEntity piesaEntity = piesaDAO.findById(piesaId)
                .orElseThrow(() -> new PiesaNotFoundException("Piesa cu id " + piesaId + " nu exista"));
        Piesa piesaModel = piesaMapper.piesaEntityToPiesaModel(piesaEntity);
        return piesaMapper.piesaModelToGetPiesaRespDTO(piesaModel);
    }

    private void checkForDuplicate(Piesa piesaModel) {
        List<PiesaEntity> piesaEntityListFromDB = piesaDAO.findAll();
        for (PiesaEntity p : piesaEntityListFromDB) {
            if (p.getNume().equalsIgnoreCase(piesaModel.getNume())) {
                throw new PiesaAlreadyExistsException("Piesa cu numele " + piesaModel.getNume() + " exista in DB!");
            }
        }
    }
}
