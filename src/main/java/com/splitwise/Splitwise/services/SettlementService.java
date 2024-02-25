package com.splitwise.Splitwise.services;

import com.splitwise.Splitwise.models.Expense;
import com.splitwise.Splitwise.models.ExpenseUser;
import com.splitwise.Splitwise.models.Group;
import com.splitwise.Splitwise.models.User;
import com.splitwise.Splitwise.repositories.ExpenseRepository;
import com.splitwise.Splitwise.repositories.ExpenseUserRepository;
import com.splitwise.Splitwise.repositories.GroupRepository;
import com.splitwise.Splitwise.repositories.UserRepository;
import com.splitwise.Splitwise.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettlementService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private ExpenseRepository expenseRepository;
    private GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;


    public List<Transaction> settleUpUser(Long userid){
        /*
        * 1. Get all the expenses that this user is part of
        * 2. Iterate through all the expenses and find all
        * the people involved and how much is owed/owes by each
        * 3. Use min and max heap algo to calculate the list of transactions
        * 4. return the list of transactions
        * */
        Optional<User> userOptional = userRepository.findById(userid);
        if(userOptional.isEmpty()){
            throw new RuntimeException();
        }
        User user = userOptional.get();
        //Get expenseUser from user
        List<ExpenseUser> expenseUserList = expenseUserRepository.findAllByUser(user);

        //Get list of expenses of which this user is a part of
        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser expenseUser: expenseUserList){
            expenses.add(expenseUser.getExpense());
        }


        List<Transaction> transactions = settleUpStrategy.settle(expenses);
        List<Transaction> filteredTransaction = new ArrayList<>();
        //for that user only get the transaction details . donot care about other users
        for (Transaction transaction: transactions){
            if(transaction.getFrom().equals(user) ||
            transaction.getTo().equals(user)){
                filteredTransaction.add(transaction);
            }
        }
        return filteredTransaction;
    }

    public List<Transaction> settleUpGroup(Long groupId){
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException();
        }

        Group group = groupOptional.get();
        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        List<Transaction> transactions = settleUpStrategy.settle(expenses);

        return transactions;


    }
}
