package com.fdm.service.controller.dto.piesa;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViewPiesaRespDTO {
    private String nume;
    private String categorie;
    private int stoc;
}
