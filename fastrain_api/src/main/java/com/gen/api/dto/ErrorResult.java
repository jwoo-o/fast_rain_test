package com.gen.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResult {

    private String message;

    private String code;

    private String error;
}