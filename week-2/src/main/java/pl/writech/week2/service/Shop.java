package pl.writech.week2.service;

import pl.writech.week2.domain.Cart;

public interface Shop {

    Cart prepareCart();

    void showProductsFromCart(Cart cart);

}
