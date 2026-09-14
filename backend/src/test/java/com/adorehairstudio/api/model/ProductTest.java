package com.adorehairstudio.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void infersLegacyWigCategoriesAsWigs() {
        Product product = new Product();
        product.setCategory("lace");

        assertEquals("WIG", product.getProductType());
    }

    @Test
    void infersLegacyNonWigCategoriesAsOtherProducts() {
        Product product = new Product();
        product.setCategory("perfume");

        assertEquals("OTHER", product.getProductType());
    }

    @Test
    void normalizesExplicitProductTypes() {
        Product product = new Product();
        product.setProductType("wig");
        assertEquals("WIG", product.getProductType());

        product.setProductType("accessory");
        assertEquals("OTHER", product.getProductType());
    }
}
