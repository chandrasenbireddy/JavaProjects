package org.chandrasen.service;

import org.chandrasen.service.ExpenseTracker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTrackerTest {
    @Test
    void addingExpenseIncreasesTotal() {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Transport", 5.0);

        //total should sum the added expenses
        assertEquals(15.0, tracker.getTotal());
    }
    @Test
    void getAllExpensesReturnsCorrectData(){
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Coffee", 3.5);
        List<Expense> expenses = tracker.getAllExpenses();
        assertEquals(1, expenses.size());
        assertEquals("Coffee", expenses.get(0).getName());
        assertEquals(3.5, expenses.get(0).getAmount());
        assertEquals(LocalDate.now(), expenses.get(0).getDate());
    }
    @Test
    void addingNegativeAmountThrowsException(){
        ExpenseTracker tracker = new ExpenseTracker();
        assertThrows(IllegalArgumentException.class, ()-> tracker.addExpense("Bad Expense", -5.0));
    }
    @Test
    void addingEmptyNameThrowsException() {
        ExpenseTracker tracker = new ExpenseTracker();
        //empty string
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense("", 20.0));
        //Null name
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense(null, 10.0));
    }
    @Test
    void totalWithNoExpenseIsZero(){
        ExpenseTracker tracker = new ExpenseTracker();
        assertEquals(0.0, tracker.getTotal());
    }
    @Test
    void totalExcludesRemovedExpenses() {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 10);
        tracker.addExpense("Coffee", 3.5);
        tracker.removeExpense("Coffee");
        assertEquals(3.5, tracker.getTotal());
    }
    @Test
    void removeNonExistingExpenseReducesTotal(){
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Coffee", 3.5);
        asserThrows(IllegalArgumentException.class, ()->tracker.removeExpense("Food"));
    }
    @Test
    void getAllExpensesReflectRemoval(){
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Coffee", 3.5);
        tracker.removeExpense("Coffee");
        assertEquals(1, tracker.getAllExpenses().size());
        assertEquals("Coffee", tracker.getAllExpenses().get(0).getName());
    }
    @Test
    void getAllExpensesReturnsCopy() {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 10.0);
        var expenses = tracker.getAllExpenses();
        expenses.clear(); // modify returned list
        // internal list should remain unchanged
        assertEquals(1, tracker.getAllExpenses().size());
    }
    @Test
    void getAllExpensesEmptyList(){
        ExpenseTracker tracker = new ExpenseTracker();
        var expenses = tracker.getAllExpenses();
        assertTrue(expenses.isEmpty());
    }
    @Test
    void saveCSVCreatesFile(@TempDir Path tempDir) throws IOException{
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 11);
        Path file = tempDir.resolve("expense.csv");
        tracker.saveToCSV(file.toString());
        assertTrue(Files.exists(file));
    }
    @Test
    void saveCSVWritesCorrectData(@TempDir Path tempDir) throws IOException{
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food", 10.0);
        tracker.addExpense("Coffee", 3.5);
        Path file = tempDir.resolve("expense.csv");
        tracker.saveToCSV(file.toString());
        List<String> lines = Files.readAllLines(file);
        assertEquals(2, lines.size());
        assertTrue(lines.get(0).startsWith("Food,10"));
        assertTrue(lines.get(1).startsWith("Coffee,3.5"));
    }
    @Test
    void overwriteExistingFile(@TempDir Path tempDir) throws IOException {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Food",12);
        Path file = tempDir.resolve("expense.csv");
        tracker.saveToCSV(file.toString());
        tracker.addExpense("Coffee", 3.5);
        tracker.saveToCSV(file.toString());
        List<String> lines = Files.readAllLines(file);
        assertEquals(2, lines.size());
    }
    @Test
    void loadCSVPopulateExpenses(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("expense.csv");
        Files.write(file, List.of("Food,10.0,2025-11-17","Coffee,3.5,2025-11-17"));
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.loadFromCSV(file.toString());
        var expenses = tracker.getAllExpenses();
        assertEquals(2,expenses.size());
        assertEquals("Food",expenses.get(0).getName());
        assertEquals(10.0, expenses.get(0).getName());
    }
    @Test
    void loadEmptyCSVReturnsEmptyList(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("expense.csv");
        Files.createFile(file);
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.loadFromCSV(file.toString());
        assertTrue(tracker.getAllExpenses().isEmpty());
    }
    @Test
    void loadMalFormedCSVThrowsException(@TempDir Path tempDir) throws IOException {
        Path file =tempDir.resolve("bad.csv");
        Files.write(file, List.of("BadCSVWithOutCommas"));
        ExpenseTracker tracker = new ExpenseTracker();
        assertThrows(IllegalArgumentException.class, () -> tracker.loadloadFromCSV(file.toString()));
    }
    @Test
    void addingZeroAmountExpenseAllowed() {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.addExpense("Free Sample", 0.0);
        assertEquals(0.0, tracker.getTotal());
        assertEquals(1,tracker.getAllExpenses().size());
    }
    @Test
    void addingNullNameThrowsException() {
        ExpenseTracker tracker = new ExpenseTracker();
        assertThrows(IllegalArgumentException.class, () -> tracker.addExpense(null, 10.0));
    }
    @Test
    void loadNonExistentCSVThrowException() {
        ExpenseTracker tracker = new ExpenseTracker();
        String invalidPath = "does_notExitst.csv";
        assertThrows(IOException.class, () -> tracker.loadFromCSV(invalidPath));
    }
}
