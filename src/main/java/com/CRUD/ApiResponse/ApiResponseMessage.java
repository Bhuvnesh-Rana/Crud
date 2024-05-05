package com.CRUD.ApiResponse;

public class ApiResponseMessage {
    public boolean status;
    public String message;

    public ApiResponseMessage(boolean status, String message){
        this.status=status;
        this.message=message;
    }
}
