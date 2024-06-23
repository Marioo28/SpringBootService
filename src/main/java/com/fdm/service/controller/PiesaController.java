package com.fdm.service.controller;

import com.fdm.service.controller.dto.piesa.*;
import com.fdm.service.service.PiesaService;
import com.fdm.service.service.mapper.PiesaMapper;
import com.fdm.service.service.model.Piesa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/piesa")
public class PiesaController {

    private final PiesaService piesaService;
    private final PiesaMapper piesaMapper;


    public PiesaController(PiesaService piesaService, PiesaMapper piesaMapper) {
        this.piesaService = piesaService;
        this.piesaMapper = piesaMapper;
    }

    @PostMapping(path = "/create")
    public CreatePiesaRespDTO createPiesa(@RequestBody CreatePiesaReqDTO createPiesaReqDTO) {
        Piesa piesaModel = piesaMapper.createPiesaReqDtoToPiesa(createPiesaReqDTO);
        return piesaService.createPiesa(piesaModel);
    }

    @GetMapping(path = "/all")
    public List<ViewPiesaRespDTO> getAllPiese(){
        return piesaService.getAllPiese();
    }


    @PutMapping(path = "/{piesaId}")
   public UpdatePiesaRespDTO updatePiesaR(@PathVariable Integer piesaId, @RequestBody UpdatePiesaReqDTO updatePiesaReqDTO){
    Piesa piesaModel = piesaMapper.updatePiesaDTOtOPisa(updatePiesaReqDTO);
    return piesaService.updatePiesa(piesaId,piesaModel);
   }

   @DeleteMapping("/{piesaId}")
   public void deletePiesa(@PathVariable Integer piesaId){
        piesaService.deletePiesa(piesaId);
   }
}