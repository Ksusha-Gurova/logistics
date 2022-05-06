package com.example.logistics.model;

public enum City {
    SAINT_PETERSBURG("Санкт-Петербург"),
    MOSCOW("Москва"),
    NOVOSIBIRSK("Новосибирск"),
    PECHORA("Печора"),
    SYKTYVKAR("Сыктывкар"),
    TAGANROG("Таганрог"),
    SAMARA("Самара");

    private final String translation;

    City(String translation){
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
