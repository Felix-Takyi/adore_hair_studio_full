package com.adorehairstudio.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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

    @Test
    void keepsTheFirstGalleryImageAsThePrimaryImage() {
        Product product = new Product();
        product.setImageUrls(List.of("first.jpg", "second.jpg", "first.jpg"));

        assertEquals("first.jpg", product.getImageUrl());
        assertEquals(List.of("first.jpg", "second.jpg"), product.getImageUrls());
    }
}
