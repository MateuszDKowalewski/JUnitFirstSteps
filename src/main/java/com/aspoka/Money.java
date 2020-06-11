package com.aspoka;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money reduce(String to) {
        return this;
    }

    public Sum plus(Money addend) {
        return new Sum(this, addend);
    }

    public String getCurrency() {
        return this.currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return money.amount == amount && this.currency == money.getCurrency();
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
}
