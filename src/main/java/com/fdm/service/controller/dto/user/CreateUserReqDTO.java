package com.fdm.service.controller.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserReqDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private int age;
    private String type;
}
