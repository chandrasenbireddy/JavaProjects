package org.chandrasen.model;

import java.time.LocalDate;
import java.util.Objects;

public class Expense {
    private final String name;
    private final double amount;
    private final LocalDate date;
    public Expense(String name, double amount, LocalDate date) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Expense name cannot be null or blank");
        }
        if(date == null){
            throw new IllegalArgumentException("date cannot be null");
        }
        if(amount < 0){
            throw new IllegalArgumentException("Amount should be zero or more");
        }
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense expense)) return false;
        return Double.compare(expense.getAmount(), getAmount()) == 0 && getName().equals(expense.getName()) && getDate().equals(expense.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAmount(), getDate());
    }
}
