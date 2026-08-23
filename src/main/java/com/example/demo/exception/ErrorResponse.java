package com.example.demo.exception;

public class ErrorResponse {
    private int status;
    private String error;
    private String messaje;

    public ErrorResponse(int status, String error, String messaje) {
        this.status = status;
        this.error = error;
        this.messaje = messaje;
    }

    public String getError() {
        return error;
    }

    public String getMessaje() {
        return messaje;
    }

    public int getStatus() {
        return status;
    }
}
