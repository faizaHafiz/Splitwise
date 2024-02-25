package com.splitwise.Splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{


    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType_id;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
}
