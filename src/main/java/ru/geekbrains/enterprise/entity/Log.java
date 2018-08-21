package ru.geekbrains.enterprise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Log extends AbstractEntity {

    @Column
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Log() {
    }

    public Log(String message) {
        this.message = message;
    }
}

