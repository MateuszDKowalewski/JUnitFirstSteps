package com.aspoka;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {


    @Test
    public void shouldReturnTrueForTheSameMoney() {
        // given
        Money first = Money.dollar(5);
        Money second = Money.dollar(5);

        // when
        boolean result = first.equals(second);

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseForDifferentAmount() {
        // given
        Money first = Money.dollar(5);
        Money second = Money.dollar(6);

        // when
        boolean result = first.equals(second);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseForDifferentCurrency() {
        // given
        Money first = Money.dollar(5);
        Money second = Money.franc(5);

        // when
        boolean result = first.equals(second);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueForTheSameCurrencyCode() {
        // given
        Money dollar = Money.dollar(1);
        String expected = "USD";

        // when
        boolean result = dollar.getCurrency().equals(expected);

        // then
        Assert.assertTrue(result);

    }

    @Test
    public void testMultiplications() {
        Money five = Money.dollar(5);
        Assert.assertEquals(Money.dollar(10), five.times(2));
        Assert.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(10), reduce);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assert.assertEquals(five, sum.augend);
        Assert.assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assert.assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        Assert.assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testSameCurrencyEquals() {
        Assert.assertEquals(1, new Bank().getRate("USD", "USD"));
    }

}
