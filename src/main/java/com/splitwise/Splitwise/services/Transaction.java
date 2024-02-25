package com.splitwise.Splitwise.services;

import com.splitwise.Splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private int amount;
    private User from;
    private User to;
}
