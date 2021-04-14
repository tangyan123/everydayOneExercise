package com.ty.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseEntity {
    private final int code;
    private final String message="success";
    private final Object data;
    private final Date timestamp;

    public static ResponseEntity build(Object data) {
        return new ResponseEntity(200, data, new Date());
    }
}
