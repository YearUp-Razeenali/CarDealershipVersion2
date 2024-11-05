package com.yearup.dealership;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getFromCSV(String filename) {
        Dealership dealership = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;

            // Read the first line for dealership info (name, address, phone)
            String[] firstLineData = bufferedReader.readLine().split("\\|");
            String name = firstLineData[0];
            String address = firstLineData[1];
            String phone = firstLineData[2];
            dealership = new Dealership(name, address, phone);

            // Read remaining lines for vehicle info
            while ((line = bufferedReader.readLine()) != null) {
                String[] newLine = line.split("\\|");
                if (newLine.length == 8) {
                    int vinNumber = Integer.parseInt(newLine[0]);
                    int makeYear = Integer.parseInt(newLine[1]);
                    String make = newLine[2];
                    String model = newLine[3];
                    String vehicleType = newLine[4];
                    String color = newLine[5];
                    int odometer = Integer.parseInt(newLine[6]);
                    double price = Double.parseDouble(newLine[7]);
                    Vehicle v = new Vehicle(vinNumber, makeYear, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(v); // Assuming addVehicle method exists
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dealership;
    }

    public static void saveToCSV(Dealership dealership, String filename) {
        try {
            // Create a file writer and assign it to the buffered writer
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            // Write dealership header
            bw.write(getEncodedDealershipHeader(dealership));

            // Loop through vehicles and write each one to the file
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(getEncodedVehicle(vehicle));
            }
            bw.close(); // Close the BufferedWriter

        } catch (IOException e) {
            System.out.println("Error while saving to CSV: " + e.getMessage());
        }
    }

    private static String getEncodedDealershipHeader(Dealership dealership) {
        return dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n";
    }

    private static String getEncodedVehicle(Vehicle vehicle) {
        return new StringBuilder()
                .append(vehicle.getVin()).append("|")
                .append(vehicle.getYear()).append("|")
                .append(vehicle.getMake()).append("|")
                .append(vehicle.getModel()).append("|")
                .append(vehicle.getVehicleType()).append("|")
                .append(vehicle.getColor()).append("|")
                .append(vehicle.getOdometer()).append("|")
                .append(vehicle.getPrice()).append("\n").toString();
    }
}
