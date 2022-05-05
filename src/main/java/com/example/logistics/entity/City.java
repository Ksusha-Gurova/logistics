package com.example.logistics.entity;

public enum City {
    SAINT_PETERSBURG("Санкт-Петербург"),
    MOSCOW("Москва"),
    NOVOSIBIRSK("Новосибирск"),
    PECHORA("Печора"),
    SYKTYVKAR("Сыктывкар"),
    TAGANROG("Таганрог"),
    SAMARA("Самара");

    private String russianCity;
    City(String russianCity){
        this.russianCity = russianCity;
    }
    public String getRussianCity(){
        return russianCity;
    }
}
