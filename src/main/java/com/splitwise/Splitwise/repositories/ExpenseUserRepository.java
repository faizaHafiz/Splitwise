package com.splitwise.Splitwise.repositories;

import com.splitwise.Splitwise.models.ExpenseUser;
import com.splitwise.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {

    List<ExpenseUser> findAllByUser(User user);
}
