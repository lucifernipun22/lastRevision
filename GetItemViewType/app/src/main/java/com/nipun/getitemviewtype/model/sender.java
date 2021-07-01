package com.nipun.getitemviewtype.model;

public class sender extends BaseModel {

    String message;

    public sender(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "sender{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        return 1;
    }
}
