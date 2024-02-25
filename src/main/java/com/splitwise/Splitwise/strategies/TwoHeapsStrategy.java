package com.splitwise.Splitwise.strategies;

import com.splitwise.Splitwise.models.Expense;
import com.splitwise.Splitwise.services.Transaction;

import java.util.List;

public class TwoHeapsStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        return null;
    }
}
