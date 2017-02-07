package com.miun.appguestbook.josu1502.appguestbook;

/**
 * Created by Joakim on 17-02-07.
 */
public class Message {

    private String name;
    private String message;

    public Message(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

