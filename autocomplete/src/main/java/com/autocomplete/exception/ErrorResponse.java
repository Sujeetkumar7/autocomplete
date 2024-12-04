package com.autocomplete.exception;

import java.util.Date;

public class ErrorResponse {
    private Date currentTime = new Date();
    private String status;
    private String message;

    public ErrorResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
