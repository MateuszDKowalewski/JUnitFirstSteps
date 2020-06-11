package com.aspoka;

import java.util.HashMap;

public class Bank {

    HashMap<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

    public int getRate(String from, String to) {
        if(from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }

}
