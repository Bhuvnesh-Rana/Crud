package com.CRUD.ApiResponse;

import com.CRUD.DTO.DemoDTO;

public class ApiResponse {
    public boolean status;
    public String message;
    public DemoDTO user;

    public ApiResponse(boolean status, String message){
        this.status=status;
        this.message=message;
    }
    public ApiResponse(boolean status, String message, DemoDTO user){
        this.status=status;
        this.message=message;
        this.user=user;
    }
}
