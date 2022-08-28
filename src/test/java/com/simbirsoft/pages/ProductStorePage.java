package com.simbirsoft.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductStorePage {

    public static final String URL = "https://www.demoblaze.com/";

    private final ElementsCollection
            categoryItems = $$(".list-group-item"),
            productList = $$(".card-title a"),
            orderData = $$("td");

    private final SelenideElement
            addToCartBtn = $(".btn-lg"),
            cartLink = $("#cartur"),
            orderBody = $("#tbodyid");

    public ProductStorePage openMenuCategory(String category) {
        categoryItems.findBy(Condition.text(category)).click();
        return this;
    }
    public ProductStorePage addItemToCart(String item) {
        productList.findBy(Condition.text(item)).click();
        addToCartBtn.click();
        Selenide.confirm();

        return this;
    }

    public ProductStorePage openCart() {
        cartLink.click();

        return this;
    }

    public ProductStorePage checkItemInCart(String item) {
        orderBody.should(Condition.visible);
        orderData.shouldHave(CollectionCondition.itemWithText(item));

        return this;
    }
}
