package com.yearup.dealership;

import java.time.LocalDate;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05; // 5%
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_OVER_10000 = 495.00;
    private boolean isFinanced;
    private double price;

    public SalesContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold, double price, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.price = price;
        this.isFinanced = isFinanced;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        double tax = price * SALES_TAX_RATE;
        double processingFee = price < 10000 ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_OVER_10000;
        totalPrice = price + tax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice; // Return the calculated total price
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced) {
            if (price >= 10000) {
                return (totalPrice * 0.0425) / 48; // 4.25% for 48 months
            } else {
                return (totalPrice * 0.0525) / 24; // 5.25% for 24 months
            }
        }
        return 0.0; // No financing
    }
}
