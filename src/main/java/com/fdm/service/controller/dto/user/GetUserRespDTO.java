package com.fdm.service.controller.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetUserRespDTO {
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String type;
}
