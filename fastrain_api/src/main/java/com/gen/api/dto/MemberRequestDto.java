package com.gen.api.dto;

import com.gen.api.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberRequestDto {

    @NotBlank
    private String id;
    @NotBlank
    private String password;

    public Member toEntity() {

        return Member.builder()
                        .id(id)
                        .password(password).build();
    }
}
