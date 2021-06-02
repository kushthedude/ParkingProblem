package com.gojek.parking;

public class Car {
    private String registration_no;
    private String color;
    private int slot_no;

    public String getColor() {
        return color;
    }

    public Car(String registration_no, String color) {
        this(registration_no, color, 0);
    }

    public Car(String registration_no, String color, int slot_no) {
        this.registration_no = registration_no;
        this.color = color;
        this.slot_no = slot_no;
    }

    public String getRegistration_no() {
        return registration_no;
    }


    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }
}
