package com.aspoka;

public interface Expression {
    Money reduce(Bank bank, String to);
}
