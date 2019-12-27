package com.ensk.demo.junit.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assume;
import org.junit.Assert;
import org.junit.runners.Parameterized;

import com.ensk.demo.junit.exception.BusinessException;

@RunWith(Parameterized.class)
public class ProductServiceTest {

    // initial letter logogram of methods
    enum Type {
        GP, GPE, GS, GSE
    }

    private Type type;
    String name;
    private ProductService productService;

    public ProductServiceTest(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                        {Type.GP, "iPhone 11 Pro Max"},
                        {Type.GP, "Nissan GT-R R36"},
                        {Type.GPE, "IPhone 11 Pro Max"},
                        {Type.GPE, "1E3T"},
                        {Type.GPE, ""},
                        {Type.GPE, null},
                        {Type.GS, "iPhone 11 Pro Max"},
                        {Type.GS, "Nissan GT-R R36"},
                        {Type.GSE, "IPhone 11 Pro Max"},
                        {Type.GSE, "1E3T"},
                        {Type.GSE, ""},
                        {Type.GSE, null}});
    }

    @Before
    public void setUp() {
        productService = new ProductService();
    }

    @After
    public void tearDown() {}

    @Test
    public void testGetPrice() throws BusinessException {
        Assume.assumeTrue(type == Type.GP);
        Assert.assertTrue(productService.getPrice(name) > 0);
    }

    @Test(expected = BusinessException.class)
    public void testGetPriceException() throws BusinessException {
        Assume.assumeTrue(type == Type.GPE);
        Assert.assertTrue(productService.getPrice(name) > 0);
    }

    @Test(timeout = 500)
    public void testGetStock() throws BusinessException {
        Assume.assumeTrue(type == Type.GS);
        Assert.assertTrue(productService.getStock(name) >= 0);
    }

    @Test(expected = BusinessException.class)
    public void testGetStockException() throws BusinessException {
        Assume.assumeTrue(type == Type.GSE);
        Assert.assertTrue(productService.getStock(name) >= 0);
    }
}
