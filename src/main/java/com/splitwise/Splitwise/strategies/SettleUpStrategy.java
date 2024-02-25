package com.splitwise.Splitwise.strategies;

import com.splitwise.Splitwise.models.Expense;
import com.splitwise.Splitwise.services.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
