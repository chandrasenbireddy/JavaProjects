package org.chandrasen.service;

import org.chandrasen.service.ExpenseTracker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.chandrasen.model.Expense;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTrackerTest {
    @Test
    void addingExpenseIncreasesTotal(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Transport", 5.0);

        //total should sum the added expenses
        assertEquals(15.0, tracker.getTotal());
    }
    @Test
    void getAllExpensesReturnsCorrectData(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Coffee", 3.5);
        List<Expense> expenses = tracker.getAllExpenses();
        assertEquals(1, expenses.size());
        assertEquals("Coffee", expenses.get(0).getName());
        assertEquals(3.5, expenses.get(0).getAmount());
        assertEquals(LocalDate.now(), expenses.get(0).getDate());
    }
    @Test
    void addingNegativeAmountThrowsException(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        assertThrows(IllegalArgumentException.class, ()-> tracker.addExpense("Bad Expense", -5.0));
    }
    @Test
    void addingEmptyNameThrowsException(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        //empty string
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense("", 20.0));
        //Null name
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense(null, 10.0));
    }
    @Test
    void totalWithNoExpenseIsZero(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        assertEquals(0.0, tracker.getTotal());
    }
    @Test
    void totalExcludesRemovedExpenses(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 10);
        tracker.addExpense("Coffee", 3.5);
        tracker.removeExpense("Coffee");
        assertEquals(10, tracker.getTotal());
    }
    @Test
    void removeNonExistingExpenseReducesTotal(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Coffee", 3.5);
        assertThrows(IllegalArgumentException.class, ()->tracker.removeExpense("Food"));
    }
    @Test
    void getAllExpensesReflectRemoval(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Coffee", 3.5);
        tracker.removeExpense("Coffee");
        assertEquals(1, tracker.getAllExpenses().size());
        assertEquals("Food", tracker.getAllExpenses().get(0).getName());
    }
    @Test
    void getAllExpensesReturnsImmutableCopy(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Food", 10.0);
        var expenses = tracker.getAllExpenses();
        assertThrows(UnsupportedOperationException.class, expenses::clear);
    }
    @Test
    void getAllExpensesEmptyList(@TempDir Path tempDir) throws IOException{
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        var expenses = tracker.getAllExpenses();
        assertTrue(expenses.isEmpty());
    }
    @Test
    void loadEmptyCSVReturnsEmptyList(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        Path file = tempDir.resolve("expense.csv");
        Files.createFile(file);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        fileService.load();
        assertTrue(tracker.getAllExpenses().isEmpty());
    }
    @Test
    void addingZeroAmountExpenseAllowed(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        tracker.addExpense("Free Sample", 0.0);
        assertEquals(0.0, tracker.getTotal());
        assertEquals(1,tracker.getAllExpenses().size());
    }
    @Test
    void addingNullNameThrowsException(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("test_expenses.csv");
        ExpenseFileService fileService = new ExpenseFileService(filePath);
        ExpenseTracker tracker = new ExpenseTracker(fileService);
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense(null, 10.0));
    }
}
