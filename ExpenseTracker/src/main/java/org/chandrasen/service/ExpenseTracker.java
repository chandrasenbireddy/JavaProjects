package org.chandrasen.service;

import org.chandrasen.model.Expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private final ExpenseFileService fileService;
    private final List<Expense> expenses = new ArrayList<>();
    public ExpenseTracker(ExpenseFileService fileService) throws IOException{
        this.fileService = fileService;
        expenses.addAll(fileService.load());
    }
    public void addExpense(String name, double amount) throws IOException{
        if(amount < 0) {
            throw new IllegalArgumentException("Expense can't be negative");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Expense name cant be null or empty");
        }
        expenses.add(new Expense(name, amount, LocalDate.now()));
    }
    public void removeExpense(String name){
        boolean removed = expenses.removeIf(e ->e.getName().equals(name));
        if(!removed) throw new IllegalArgumentException("No element like " + name + " exists int he list");
    }
    public double getTotal(){
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
    public List<Expense> getAllExpenses(){
        return List.copyOf(expenses);
    }
    public void saveExpenses() throws IOException{
        fileService.save(expenses);
    }
}
