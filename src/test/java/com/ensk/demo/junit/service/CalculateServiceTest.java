package com.ensk.demo.junit.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateServiceTest {

    @Test
    public void testAdd() {
        assertEquals(6, new CalculateService().add(3, 3));
    }

    @Test
    public void testsubstract() {
        assertEquals(2, new CalculateService().subtract(5, 3));
    }

    @Test
    public void testcheng() {
        assertEquals(15, new CalculateService().multiply(5, 3));
    }

    @Test
    public void testchu() {
        assertEquals(2, new CalculateService().divide(6, 3));
    }
}