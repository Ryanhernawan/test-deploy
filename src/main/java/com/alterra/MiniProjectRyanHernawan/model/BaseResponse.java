package com.alterra.MiniProjectRyanHernawan.model;

import lombok.Data;

@Data
public class BaseResponse<T>{
    private Boolean success;
    private String message;
    private T data;
}
