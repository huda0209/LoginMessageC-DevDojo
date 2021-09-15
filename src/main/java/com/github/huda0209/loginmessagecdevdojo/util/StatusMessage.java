package com.github.huda0209.loginmessagecdevdojo.util;

public class StatusMessage {
    private Boolean status;
    private String message;

    public StatusMessage(Boolean status, String message){
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus(){
        return status;
    }

    public String getMessage() {
        return message;
    }
}