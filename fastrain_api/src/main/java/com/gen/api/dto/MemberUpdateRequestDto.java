package com.gen.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberUpdateRequestDto {

    @NotBlank
    private String password;
}
