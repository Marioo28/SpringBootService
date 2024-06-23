package com.fdm.service.controller.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetUserReqDTO {
    private String username;
}
