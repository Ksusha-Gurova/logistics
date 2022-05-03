package com.example.logistics.entity;

public enum Status {
    ACCEPTED("Принят пунктом приема для дальнейшей транспортировки"),
    DELIVERY("Передан для транспортировки (в пути)"),
    COMPLETED("Выдан получателю");

    Status(String message){}
}
