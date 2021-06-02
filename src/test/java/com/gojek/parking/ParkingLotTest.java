package com.gojek.parking;

import com.gojek.parking.exception.InvalidSlotException;
import com.gojek.parking.exception.ParkingFullException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkingLotTest{
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private Car car;
    private ParkingLot lot;

    @Before
    public void CreateLotCar(){
        car = new Car("test", "test");
        lot = new ParkingLot(1);
    }

    @Test
    public void ParkingLot_canCreateLot(){
        assertEquals(1, lot.getSlots());
        assertEquals("ParkingLotcreatedwithcapacity1", systemOutRule.getLog().replaceAll("\\s",""));
    }

    @Test
    public void ParkingLot_canParkCar() throws ParkingFullException {
        lot.parkCar(car);
        assertEquals("ParkingLotcreatedwithcapacity1Allocatedslot0tocartestwithcolortest", systemOutRule.getLog().replaceAll("\\s",""));
        assertEquals(true, lot.getEmptySlots().isEmpty());
        assertEquals(0, car.getSlot_no());
    }

    @Test
    public void ParkingLot_canExitCar() throws ParkingFullException, InvalidSlotException {
        lot.parkCar(car);
        lot.exitCar(0);
        assertEquals("ParkingLotcreatedwithcapacity1Allocatedslot0tocartestwithcolortestRemovedcarwithreg_notestslotnumber0isvacant", systemOutRule.getLog().replaceAll("\\s",""));
        assertEquals(false, lot.getEmptySlots().isEmpty());
    }
}
