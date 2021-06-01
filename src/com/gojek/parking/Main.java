package com.gojek.parking;

import java.io.*;
import com.gojek.parking.exception.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = null;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        // Loop forever
        for(;;) {
            // Display a prompt to the user
            System.out.print("ParkingLot>");
            // Read a line from the user
            String line = in.readLine();
            // If we reach the end-of-file,
            // or if the user types "quit", then quit
            if ((line == null) || line.equals("quit")) break;
            // Try to parse the line, and compute and print the factorial
            
    }
}
