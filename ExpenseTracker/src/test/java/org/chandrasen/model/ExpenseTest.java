package org.chandrasen.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpenseTest {
    @Test
    void creatingValidExpensesStoresDataCorrectly() {
        Expense e = new Expense("Coffee", 5.50, LocalDate.of(2025,11,18));
        assertEquals("Coffee", e.getName());
        assertEquals(5.50, e.getAmount());
        assertEquals(LocalDate.of(2025,11,18), e.getDate());
    }
    @Test
    void creatingExpenseWithEmptyNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Expense("",10.0,LocalDate.now()));
    }
    @Test
    void creatingExpenseWithNullNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Expense(null, 10.0, LocalDate.now()));
    }
    @Test
    void cratingExpenseWithNegativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Expense("Dinner", -20, LocalDate.now()));
    }
    @Test
    void creatingExpenseWithNullDateThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Expense("Dinner", 20, null));
    }
    @Test
    void equalExpensesAreEqual(){
        Expense e1 = new Expense("Book", 12, LocalDate.of(2025,1,1));
        Expense e2 = new Expense("Book", 12, LocalDate.of(2025,1,1));
        assertEquals(e1,e2);
    }
}
