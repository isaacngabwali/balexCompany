package com.mycompany.balexcompany;

public class BalexCompany {

        public static void calculatePay(double basePay, int hoursWorked) {
        final double MINIMUM_WAGE = 8.00;
        final int MAX_HOURS = 60;
        final int OVERTIME_THRESHOLD = 40;

        if (basePay < MINIMUM_WAGE) {
            System.out.println("Error: Base pay must be at least $" + MINIMUM_WAGE + " per hour.");
            return;
        }

        if (hoursWorked > MAX_HOURS) {
            System.out.println("Error: Hours worked cannot exceed " + MAX_HOURS + " hours.");
            return;
        }

        double totalPay = 0.0;

        if (hoursWorked > OVERTIME_THRESHOLD) {
            // Regular pay for the first 40 hours
            totalPay = OVERTIME_THRESHOLD * basePay;
            // Overtime pay for the remaining hours
            totalPay += (hoursWorked - OVERTIME_THRESHOLD) * basePay * 1.5;
        } else {
            // Regular pay if no overtime
            totalPay = hoursWorked * basePay;
        }

        System.out.println("Total pay: $" + totalPay);
    }

    public static void main(String[] args) {
        // Employees data
        double[][] employees = {
            {7.50, 35},
            {8.20, 47},
            {10.00, 73}
        };

        // Calculate and print pay for each employee
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            calculatePay(employees[i][0], (int) employees[i][1]);
            System.out.println();
        }
    }
}