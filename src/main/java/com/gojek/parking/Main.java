package com.gojek.parking;

import java.io.*;
import com.gojek.parking.exception.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = null;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        // Loop forever./
        for(;;) {
            // Display a prompt to the user
            System.out.print("ParkingLot>");
            // Read a line from the user
            String line = in.readLine();
            // If we reach the end-of-file,
            // or if the user types "quit", then quit
            if ((line == null) || line.equals("quit")) break;
            try {
                String x = line;
                String[] inputCommand = x.split(" ");
                String command = inputCommand[0].toLowerCase();
                switch (command){
                    case Constants.CREATE:
                        int size = Integer.parseInt(inputCommand[1]);
                        parkingLot = new ParkingLot(size);
                        break;
                    case Constants.PARK:
                        String regNum = inputCommand[1];
                        String color = inputCommand[2];
                        Car car = new Car(regNum, color);
                        assert parkingLot != null;
                        parkingLot.parkCar(car);
                        break;
                    case Constants.LEAVE:
                        Integer slotNum = Integer.parseInt(inputCommand[1]);
                        assert parkingLot != null;
                        parkingLot.exitCar(slotNum);
                        break;
                    case Constants.STATUS:
                        assert parkingLot != null;
                        parkingLot.status();
                        break;
                    case Constants.REG_NO_COLOR:
                        assert parkingLot != null;
                        parkingLot.regNumberFromColor(inputCommand[1]);
                        break;
                    case Constants.SLOT_NO_CAR:
                        assert parkingLot != null;
                        parkingLot.getSlotFromRegistration(inputCommand[1]);
                        break;
                    default:
                        System.out.println("Please provide a valid input");
                }
            }
            // If anything goes wrong, display a generic error message
            catch (InvalidSlotException e) { System.out.println(e); }
            catch (EmptyException e) { System.out.println(e); }
            catch (ParkingFullException e) { System.out.println(e); }
            catch(Exception e) { System.out.println("Invalid Input"); }
        }
    }
}
