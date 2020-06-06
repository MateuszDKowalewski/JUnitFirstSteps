package com.aspoka;

public class Dollar {

    int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object object) {
        Dollar other = (Dollar) object;
        return ((Dollar) object).amount == amount;
    }

}
