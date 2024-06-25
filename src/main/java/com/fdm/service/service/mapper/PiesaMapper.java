package com.fdm.service.service.mapper;

import com.fdm.service.controller.dto.piesa.*;
import com.fdm.service.controller.dto.user.GetUserRespDTO;
import com.fdm.service.controller.dto.user.UpdateUserReqDTO;
import com.fdm.service.repository.PiesaRepository;
import com.fdm.service.repository.entity.PiesaEntity;
import com.fdm.service.service.model.Piesa;
import org.springframework.stereotype.Component;

@Component
public class PiesaMapper {
    private final PiesaRepository piesaRepository;

    public PiesaMapper(PiesaRepository piesaRepository) {
        this.piesaRepository = piesaRepository;
    }

    public Piesa createPiesaReqDtoToPiesa(CreatePiesaReqDTO createPiesaReqDTO) {
        return Piesa.builder()
                .stoc(createPiesaReqDTO.getStoc())
                .nume(createPiesaReqDTO.getNume())
                .categorie(createPiesaReqDTO.getCategorie())
                .build();
    }

    public CreatePiesaRespDTO piesaModelToCreatePiesaRespDTO(Piesa piesaModel) {
        return CreatePiesaRespDTO.builder()
                .nume(piesaModel.getNume())
                .categorie(piesaModel.getCategorie())
                .stoc(piesaModel.getStoc())
                .build();
    }

    public PiesaEntity piesaModelToPiesaEntity(Piesa piesaModel) {
        return PiesaEntity.builder()
                .nume(piesaModel.getNume())
                .categorie(piesaModel.getCategorie())
                .stoc(piesaModel.getStoc())
                .build();
    }

    public Piesa piesaEntityToPiesaModel(PiesaEntity piesaEntity) {
        return Piesa.builder()
                .categorie(piesaEntity.getCategorie())
                .nume(piesaEntity.getNume())
                .stoc(piesaEntity.getStoc())
                .build();
    }

    public ViewPiesaRespDTO piesaModelToViewPiesaRespDTO(Piesa piesaModel) {
        return ViewPiesaRespDTO.builder()
                .categorie(piesaModel.getCategorie())
                .nume(piesaModel.getNume())
                .stoc(piesaModel.getStoc())
                .build();
    }

    public UpdatePiesaRespDTO updatePiesaRespDTO(Piesa piesaModel) {
        return UpdatePiesaRespDTO.builder()
                .categorie(piesaModel.getCategorie())
                .nume(piesaModel.getNume())
                .stoc(piesaModel.getStoc())
                .build();
    }

    public Piesa updatePiesaDTOtOPisa(UpdatePiesaReqDTO updatePiesaReqDTO) {
        return Piesa.builder()
                .categorie(updatePiesaReqDTO.getCategorie())
                .nume(updatePiesaReqDTO.getNume())
                .stoc(updatePiesaReqDTO.getStoc())
                .build();
    }

    public void deletePiesaById(Integer piesaId) {
        piesaRepository.deleteById(piesaId);
    }

    public GetPiesaRespDTO piesaModelToGetPiesaRespDTO(Piesa piesaModel) {
        return GetPiesaRespDTO.builder()
                .categorie(piesaModel.getCategorie())
                .nume(piesaModel.getNume())
                .stoc(piesaModel.getStoc())
                .build();
    }
}
