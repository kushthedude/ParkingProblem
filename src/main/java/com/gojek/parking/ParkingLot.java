package com.gojek.parking;

import com.gojek.parking.exception.EmptyException;
import com.gojek.parking.exception.InvalidSlotException;
import com.gojek.parking.exception.ParkingFullException;

import java.util.*;

public class ParkingLot {
    private int slots = -1;
    private Map<Integer, Car> slotToCar;

    public int getSlots() {
        return slots;
    }

    private TreeSet<Integer> emptySlots;

    public TreeSet<Integer> getEmptySlots() {
        return emptySlots;
    }

    public ParkingLot(int slots) {
        this.slots = slots;
        slotToCar = new HashMap<Integer, Car>();
        emptySlots = new TreeSet<Integer>();
        for (int i = 0; i < slots; i++) {
            emptySlots.add(i);
        }
        System.out.println("Parking Lot created with capacity " + slots);
    }

    public void parkCar(Car car) throws ParkingFullException {
        if(emptySlots.isEmpty()){
            throw new ParkingFullException("parking is full");
        }
        int slotGiven = emptySlots.pollFirst();
        car.setSlot_no(slotGiven);
        slotToCar.put(slotGiven, car);
        System.out.println("Allocated slot " + slotGiven + " to car " + car.getRegistration_no() + " with color " + car.getColor());
    }

    public void exitCar(int slotNumber) throws InvalidSlotException {
        if(slotToCar.containsKey(slotNumber)){
            Car removeCar = slotToCar.get(slotNumber);
            slotToCar.remove(slotNumber);
            System.out.println("Removed car with reg_no " + removeCar.getRegistration_no());
            emptySlots.add(slotNumber);
            System.out.println("slot number " + slotNumber + " is vacant");
        } else {
            throw new InvalidSlotException("no such slot exists");
        }
    }

    public void status() throws EmptyException {
        if (slotToCar.isEmpty()){
            throw new EmptyException("No cars parkes");
        }
        System.out.println("Slot No.\nRegistration No.\nColour");
        for (int i = 0; i <= slots; i++) {
            Car car = slotToCar.get(i);
            if (car != null) {
                System.out.println(i + "\n" + car.getRegistration_no() + "\n" + car.getColor() + "\n");
            }
        }
    }

    public void regNumberFromColor(String color) throws EmptyException{
        int carsFound = 0;
        for (int i = 0; i < slots; i++) {

            Car car = slotToCar.get(i);
            if(car != null && car.getColor().equals(color)){
                System.out.println(car.getRegistration_no());
                carsFound++;
            }
        }
        if (carsFound == 0)
        {
            throw new EmptyException("No cars of color " + color +" present in the lot");
        }
    }

    public void getSlotFromRegistration(String registrationNo) throws EmptyException{
        int carsFound = 0;
        for (int i = 0; i < slots; i++) {
            Car car = slotToCar.get(i);
            if(car != null && car.getRegistration_no().equals(registrationNo)){
                System.out.println(car.getSlot_no());
                carsFound++;
            }
        }
        if (carsFound == 0)
        {
            throw new EmptyException("No cars found with registration number " + registrationNo +" in the lot");
        }
    }

}
