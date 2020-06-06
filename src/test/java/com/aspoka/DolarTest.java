package com.aspoka;

import org.junit.Assert;
import org.junit.Test;

public class DolarTest {

    @Test
    public void testMultiplications() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assert.assertEquals(10, product.amount);
        product = five.times(3);
        Assert.assertEquals(15, product.amount);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(new Dollar(5).equals(new Dollar((5))));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}
