package com.gojek.parking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConstantsTest{
    @Test
    public void constantsValues_shouldBeEqual(){
        Assertions.assertEquals("status", Constants.STATUS);
        Assertions.assertEquals("leave", Constants.LEAVE);
        Assertions.assertEquals("create", Constants.CREATE);
        Assertions.assertEquals("registration_numbers_for_cars_with_colour", Constants.REG_NO_COLOR);
        Assertions.assertEquals("slot_number_for_registration_number", Constants.SLOT_NO_CAR);
    }
}