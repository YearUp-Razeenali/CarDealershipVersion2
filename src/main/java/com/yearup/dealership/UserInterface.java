package com.yearup.dealership;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;

    public UserInterface() {
        fileManager = new DealershipFileManager();
        init();
    }

    private void init() {
        dealership = fileManager.getFromCSV("inventory.csv");
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        int command;

        do {
            System.out.println("Welcome to " + dealership.getName());
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell/Lease a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");
            command = scanner.nextInt();

            switch (command) {
                // ... (existing cases)

                case 10:
                    sellOrLeaseVehicle(scanner);
                    break;

                case 99:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (command != 99);

        scanner.close();
    }

    private void sellOrLeaseVehicle(Scanner scanner) {
        // Collecting customer information
        String customerName = Console.PromptForString("Enter customer name: ");
        String customerEmail = Console.PromptForString("Enter customer email: ");

        // Collecting vehicle VIN
        int vin = Console.PromptForInt("Enter VIN of the vehicle: ");
        Vehicle vehicle = null;

        // Find the vehicle in the inventory
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        // Asking for contract type (sale or lease)
        String type = Console.PromptForString("Is this a sale or lease? (Enter 'sale' or 'lease'): ");
        Contract contract;

        if (type.equalsIgnoreCase("sale")) {
            System.out.println("Enter details for the sale:");
            LocalDate date = LocalDate.now(); // Assuming current date for the contract
            boolean isFinanced = Console.PromptForYesNo("Is this financed? (Y/N): ");

            // Create SalesContract
            double price = vehicle.getPrice();
            contract = new SalesContract(date, customerName, customerEmail, vehicle, price, isFinanced);
        } else if (type.equalsIgnoreCase("lease")) {
            System.out.println("Enter details for the lease:");
            LocalDate date = LocalDate.now(); // Assuming current date for the contract

            // Lease-specific information
            contract = new LeaseContract(date, customerName, customerEmail, vehicle, vehicle.getPrice());
        } else {
            System.out.println("Invalid option.");
            return;
        }

        // Save the contract
        ContractFileManager.saveContract(contract, "contracts.csv");
        System.out.println("Contract saved successfully!");
    }
}
