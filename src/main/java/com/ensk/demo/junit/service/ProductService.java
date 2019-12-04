package com.ensk.demo.junit.service;

import com.ensk.demo.junit.exception.BusinessException;

public class ProductService {

    public double getPrice(String name) throws BusinessException {

        if ("iPhone 11 Pro Max".equals(name)) {
            return 7999.00;
        } else if ("Nissan GT-R R36".equals(name)) {
            return 2060000.00;
        } else {
            throw new BusinessException(String.format("unsupported product: %s", name));
        }
    }

    public int getStock(String name) throws BusinessException {
        if ("iPhone 11 Pro Max".equals(name)) {
            return 100;
        } else if ("Nissan GT-R R36".equals(name)) {
            return 66;
        } else {
            throw new BusinessException(String.format("unsupported product: %s", name));
        }
    }
}
