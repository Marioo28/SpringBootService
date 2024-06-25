package com.fdm.service.controller;

import com.fdm.service.controller.dto.piesa.*;
import com.fdm.service.service.PiesaService;
import com.fdm.service.service.mapper.PiesaMapper;
import com.fdm.service.service.model.Piesa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreatePiesaRespDTO> createPiesa(@RequestBody CreatePiesaReqDTO createPiesaReqDTO) {
        Piesa piesaModel = piesaMapper.createPiesaReqDtoToPiesa(createPiesaReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(piesaService.createPiesa(piesaModel));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ViewPiesaRespDTO>> getAllPiese() {
        return ResponseEntity.ok(piesaService.getAllPiese());
    }

    @PutMapping(path = "/{piesaId}")
    public ResponseEntity<UpdatePiesaRespDTO> updatePiesa(@PathVariable Integer piesaId, @RequestBody UpdatePiesaReqDTO updatePiesaReqDTO) {
        Piesa piesaModel = piesaMapper.updatePiesaDTOtOPisa(updatePiesaReqDTO);
        return ResponseEntity.ok(piesaService.updatePiesa(piesaId, piesaModel));
    }

    @DeleteMapping("/{piesaId}")
    public ResponseEntity<Void> deletePiesa(@PathVariable Integer piesaId) {
        piesaService.deletePiesa(piesaId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{piesaId}")
    public ResponseEntity<GetPiesaRespDTO> getPiesaById(@PathVariable int piesaId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(piesaService.getPiesaById(piesaId));
    }
}