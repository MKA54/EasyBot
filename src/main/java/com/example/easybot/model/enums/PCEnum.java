package com.example.easybot.model.enums;

public enum PCEnum {
    Desktop("desktop"),
    Nettop("nettop"),
    Monoblock("monoblock");

    private final String type;

    PCEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
