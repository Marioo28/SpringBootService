package com.fdm.service.controller.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViewUserRespDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private int age;
    private String type;
}
