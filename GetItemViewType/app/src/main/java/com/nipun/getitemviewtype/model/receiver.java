package com.nipun.getitemviewtype.model;

import java.sql.Timestamp;

public class receiver extends BaseModel {

    String message;
    String  timestamp;

    public receiver(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "receiver{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }


    @Override
    public int getItemType() {
        return 2;
    }
}
