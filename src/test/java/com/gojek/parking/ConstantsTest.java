package com.gojek.parking;

import static org.junit.Assert.*;
import org.junit.Test;


public class ConstantsTest{
    @Test
    public void constantsValues_shouldBeEqual(){
        assertEquals("status", Constants.STATUS);
        assertEquals("leave", Constants.LEAVE);
        assertEquals("create", Constants.CREATE);
        assertEquals("registration_numbers_for_cars_with_colour", Constants.REG_NO_COLOR);
        assertEquals("slot_number_for_registration_number", Constants.SLOT_NO_CAR);
    }
}