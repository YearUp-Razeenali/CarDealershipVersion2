package com.yearup.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_RATE = 0.07; // 7% of the original price
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold, double price) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = price * 0.50; // 50% of original price
        this.leaseFee = price * LEASE_FEE_RATE;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        totalPrice = expectedEndingValue + leaseFee; // Total price includes ending value and lease fee
    }

    @Override
    public double getTotalPrice() {
        return totalPrice; // Return the calculated total price
    }

    @Override
    public double getMonthlyPayment() {
        return (totalPrice * 0.04) / 36; // 4.0% for 36 months
    }
}
