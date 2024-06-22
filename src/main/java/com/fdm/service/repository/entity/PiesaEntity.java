package com.fdm.service.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "piesa")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PiesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nume;
    private String categorie;
    private int stoc;

}
