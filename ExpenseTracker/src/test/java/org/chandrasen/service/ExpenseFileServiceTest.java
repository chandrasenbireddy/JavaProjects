package org.chandrasen.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpenseFileServiceTest {
    @Test
    void saveCSVCreatesFile(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 11);
        fileService.save(tracker.getAllExpenses());
        assertTrue(Files.exists(filePath));
    }
    @Test
    void saveCSVWritesCorrectData(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Coffee", 3.5);
        fileService.save(tracker.getAllExpenses());
        List<String> lines = Files.readAllLines(filePath);
        assertEquals(2, lines.size());
        assertTrue(lines.get(0).startsWith("Food,10"));
        assertTrue(lines.get(1).startsWith("Coffee,3.5"));
    }
    @Test
    void overwriteExistingFile(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food",12);
        fileService.save(tracker.getAllExpenses());
        tracker.addExpense("Coffee", 3.5);
        fileService.save(tracker.getAllExpenses());
        List<String> lines = Files.readAllLines(filePath);
        assertEquals(2, lines.size());
    }
    @Test
    void loadCSVPopulateExpenses(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        Files.write(filePath, List.of("Food,10.0,2025-11-17","Coffee,3.5,2025-11-17"));
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        fileService.load();
        var expenses = tracker.getAllExpenses();
        assertEquals(2,expenses.size());
        assertEquals("Food",expenses.get(0).getName());
        assertEquals(10.0, expenses.get(0).getAmount());
        assertEquals("Coffee", expenses.get(1).getName());
        assertEquals(3.5, expenses.get(1).getAmount());
    }
    @Test
    void loadMalFormedCSVThrowsException(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("bad.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        Files.write(filePath, List.of("BadCSVWithOutCommas"));
        assertThrows(IllegalArgumentException.class, fileService::load);
    }
    @Test
    void loadNonExistentCSVReturnsEmptyList(@TempDir Path tempDir) throws IOException {
        Path missing = tempDir.resolve("does_not_exist.csv");
        ExpenseFileService fileService = new ExpenseFileService(missing);
        assertTrue(fileService.load().isEmpty());
    }
}
