package com.example.simple.myspringboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private Integer status;
    private String message;
    private Object data;

    public ApiResponse(Integer status, String message, Object data) {
        this.status=status;
        this.message=message;
        this.data=data;
    }

    public ApiResponse(Integer status, String message) {
        this.status=status;
        this.message=message;
    }

    public ApiResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public ApiResponse setMessage(String message) {
        this.message = message;
        return this;
    }
    public ApiResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
