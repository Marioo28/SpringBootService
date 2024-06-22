package com.fdm.service.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Piesa {
    private String nume;
    private String categorie;
    private int stoc;
}
