package com.airline.models;

public class EmailQuestion {
    private final String subject;
    private final String message;
    private final String email;

    public EmailQuestion(String subject, String message, String email) {
        this.subject = subject;
        this.message = message;
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return subject;
    }
}
