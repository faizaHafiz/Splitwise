package com.splitwise.Splitwise.commands;

public interface Command {
    public Boolean matches(String inp);
    public void execute(String inp);
}
