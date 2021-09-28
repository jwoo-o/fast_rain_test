package com.gen.api.advice;


import com.gen.api.exception.AlreadyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(AlreadyException.class)
    public ResponseEntity<Map<String,Object>> alreadyException() {

        Map<String,Object> result = new HashMap<>();

        result.put("message", "이미 등록된 아이디 입니다.");
        result.put("code", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> illegalArgumentException() {

        Map<String,Object> result = new HashMap<>();

        result.put("message", "등록되어있지 않습니다");
        result.put("code", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> methodArgumentNotValidException() {

        Map<String,Object> result = new HashMap<>();

        result.put("message", "필수 요청 데이터가 없습니다");
        result.put("code", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
