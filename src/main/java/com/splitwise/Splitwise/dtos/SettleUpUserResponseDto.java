package com.splitwise.Splitwise.dtos;

import com.splitwise.Splitwise.services.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Transaction> transactions;
}
