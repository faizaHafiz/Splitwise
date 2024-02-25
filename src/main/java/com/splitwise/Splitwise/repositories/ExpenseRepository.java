package com.splitwise.Splitwise.repositories;

import com.splitwise.Splitwise.models.Expense;
import com.splitwise.Splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
}
