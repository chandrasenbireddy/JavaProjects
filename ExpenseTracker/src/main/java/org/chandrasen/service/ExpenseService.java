package org.chandrasen.service;

import org.chandrasen.model.Expense;

import java.io.IOException;
import java.util.List;

public interface ExpenseService {
    void save(List<Expense> expenses) throws IOException;
    List<Expense> load() throws IOException;
}
