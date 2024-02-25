package com.splitwise.Splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "UserGroup")
@Getter
@Setter
public class Group extends BaseModel{
    @ManyToMany
    private List<User> userList;
    private String name;
    @ManyToOne
    private User admin;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
