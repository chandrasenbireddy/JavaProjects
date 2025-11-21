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

public class ExpenseFileService implements ExpenseService{
    private final Path filePath;
    public ExpenseFileService(Path filePath){
        this.filePath = filePath;
    }
    @Override
    public void  save(List<Expense> expenses) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)){
            for(Expense e: expenses){
                writer.write(e.getName() + "," + e.getAmount() + "," + e.getDate() + "\n");
            }
        }
    }
    @Override
    public List<Expense> load() throws IOException{
        Path path = filePath;
        if (!Files.exists(path)) {
            return new ArrayList<>(); // start empty
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            List<Expense> result = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length != 3){
                    throw new IllegalArgumentException("Invalid CSV Format : " + line);
                }
                String name = parts[0];
                double amount = Double.parseDouble(parts[1]);
                LocalDate date = LocalDate.parse(parts[2]);
                result.add(new Expense(name, amount, date));
            }
            return result;
        }
    }
}
