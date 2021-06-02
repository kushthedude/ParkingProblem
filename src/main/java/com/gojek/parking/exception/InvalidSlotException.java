package com.gojek.parking.exception;

public class InvalidSlotException extends Exception{
    public InvalidSlotException(String s){
        super(s);
    }
}
