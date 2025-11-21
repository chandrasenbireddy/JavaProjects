package org.chandrasen.app;

import org.chandrasen.service.ExpenseFileService;
import org.chandrasen.service.ExpenseTracker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Expense Tracker Application!");
        Scanner scanner = new Scanner(System.in);
        ExpenseFileService fileService = new ExpenseFileService(Path.of("expenses.csv"));
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        while(true){
            System.out.println("Enter your choice: \n1. Add Expense \n2. Remove Expense \n3. View Total Expenses \n4. View All Expenses \n5. Save \n6.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter expense name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(name, amount);
                }
                case 2-> {
                    System.out.println("Enter expense name to remove: ");
                    String name = scanner.nextLine();
                    tracker.removeExpense(name);
                }
                case 3-> {
                    System.out.println("Total Expenses: " + tracker.getTotal());
                }
                case 4 -> {
                    System.out.println("All Expenses: ");
                    tracker.getAllExpenses().forEach(e -> System.out.println(e.getName() + " - " + e.getAmount() + " - " + e.getDate()));
                }
                case 5 -> {
                    tracker.saveExpenses();
                    System.out.println("Expenses saved successfully.");
                }
                case 6 -> {
                    System.out.println("Have a nice day! Goodbye! :) ");
                    return;
                }
                default -> System.out.println("Invalid Choice, please try again.");
            }
        }
    }
}
