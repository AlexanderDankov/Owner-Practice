package com.simbirsoft.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.simbirsoft.pages.ProductStorePage.URL;

public class ProductStoreTest extends TestBase {

    @Test
    void addIphoneToCartTest() {
        open(URL);
        storePage
                .openMenuCategory("Phones")
                .addItemToCart("Iphone 6 32gb")
                .openCart()
                .checkItemInCart("Iphone 6 32gb");
    }
}
