package com.yearup.dealership;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    // Method to remove a vehicle
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


    public static class Console {

        // Static scanner for input
        static Scanner scanner = new Scanner(System.in);

        // Method to prompt a String input
        public static String PromptForString(String prompt){
            System.out.print(prompt);
            return scanner.nextLine();
        }

        // Method to prompt a String input without asking prompt
        public static String PromptForString(){
            return scanner.nextLine();
        }

        //Method to prompt a Boolean input
        public static boolean PromptForYesNo(String prompt){
            System.out.print(prompt + "( Y for Yes, N for No ): ");
            String boolInput = scanner.nextLine();

            return
                    (
                            boolInput.equalsIgnoreCase("Y")
                                    ||
                                    boolInput.equalsIgnoreCase("YES")
                    );

        }

        //Method to prompt a Short input
        public static short PromptForShort(String prompt){
            System.out.print(prompt);
            String value = scanner.nextLine();
            short shortInput = Short.parseShort(value);
            return shortInput;
        }

        //Method to prompt an Integer input
        public static int PromptForInt(String prompt){
            System.out.print(prompt);
            String value = scanner.nextLine();
            int intInput = Integer.parseInt(value);
            return intInput;
        }

        //Method to prompt an Integer input without asking prompt
        public static int PromptForInt(){
            String value = scanner.nextLine();
            int intInput = Integer.parseInt(value);
            return intInput;
        }

        //Method to prompt a Double input
        public static double PromptForDouble(String prompt){
            System.out.print(prompt);
            String userInputs = scanner.nextLine();
            double doubleInput = Double.parseDouble(userInputs);
            return doubleInput;
        }

        //Method to prompt a Byte input
        public static byte PromptForByte(String prompt){
            System.out.print(prompt);
            String value = scanner.nextLine();
            byte byteInput = Byte.parseByte(value);
            return byteInput;
        }

        //Method to prompt a Byte input without asking prompt
        public static byte PromptForByte(){
            String value = scanner.nextLine();
            byte byteInput = Byte.parseByte(value);
            return byteInput;
        }

        //Method to prompt a Float input
        public static float PromptForFloat(String prompt){
            System.out.print(prompt);
            String value = scanner.nextLine();
            float floatInput =Float.parseFloat(value);
            return floatInput;
        }

        //Method to prompt to input LocalDate
        public static LocalDate PromptForDate(String prompt) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            LocalDate dateInput = LocalDate.parse(value);
            return dateInput;
        }

        //Method to prompt to input LocalTime
        public static LocalTime PromptForTime(String prompt) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            LocalTime timeInput = LocalTime.parse(value);
            return timeInput;
        }
    }
}
