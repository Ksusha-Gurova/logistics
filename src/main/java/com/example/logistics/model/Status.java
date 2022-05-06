package com.example.logistics.model;

public enum Status {
    ACCEPTED("Принят пунктом приема для дальнейшей транспортировки"),
    DELIVERY("Передан для транспортировки (в пути)"),
    COMPLETED("Выдан получателю");

    private final String message;

    Status(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

