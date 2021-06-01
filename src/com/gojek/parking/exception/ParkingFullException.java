package com.gojek.parking.exception;

public class ParkingFullException extends Exception{
    public ParkingFullException(String s){
        super(s);
    }
}
