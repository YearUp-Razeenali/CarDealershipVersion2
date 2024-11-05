package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public static void saveContract(Contract contract, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            StringBuilder contractData = new StringBuilder();
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                contractData.append("SALE|")
                        .append(salesContract.getDate()).append("|")
                        .append(salesContract.getCustomerName()).append("|")
                        .append(salesContract.getCustomerEmail()).append("|")
                        .append(salesContract.getVehicleSold().getVin()).append("|")
                        .append(salesContract.getVehicleSold().getMake()).append("|")
                        .append(salesContract.getTotalPrice()).append("|")
                        .append(salesContract.getMonthlyPayment()).append("\n");
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                contractData.append("LEASE|")
                        .append(leaseContract.getDate()).append("|")
                        .append(leaseContract.getCustomerName()).append("|")
                        .append(leaseContract.getCustomerEmail()).append("|")
                        .append(leaseContract.getVehicleSold().getVin()).append("|")
                        .append(leaseContract.getVehicleSold().getMake()).append("|")
                        .append(leaseContract.getTotalPrice()).append("|")
                        .append(leaseContract.getMonthlyPayment()).append("\n");
            }
            bw.write(contractData.toString());
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
