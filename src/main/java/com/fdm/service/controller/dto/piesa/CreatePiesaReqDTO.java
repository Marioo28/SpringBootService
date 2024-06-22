package com.fdm.service.controller.dto.piesa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePiesaReqDTO {
    private String nume;
    private String categorie;
    private int stoc;
}
