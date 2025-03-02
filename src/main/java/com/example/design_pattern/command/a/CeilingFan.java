package com.example.design_pattern.command.a;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private int speed;

    public CeilingFan() {
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("Fan is on HIGH");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("Fan is on MEDIUM");
    }

    public void low() {
        speed = LOW;
        System.out.println("Fan is on LOW");
    }

    public void off() {
        speed = OFF;
        System.out.println("Fan is OFF");
    }

    public int getSpeed() {
        return speed;
    }
}
