package com.example.kioi.jkuatportal;

public class InstantMessage {

    private String message;
    private String author;

    public InstantMessage(String message, String author) {
        this.author = author;
        this.message = message;

    }

    public InstantMessage() {
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
