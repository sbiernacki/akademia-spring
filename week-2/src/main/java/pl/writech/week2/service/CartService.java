package pl.writech.week2.service;

import pl.writech.week2.domain.Cart;

import java.math.BigDecimal;

public interface CartService {

    Cart createCart();

    BigDecimal calculateSum(Cart cart);

    BigDecimal calculateSumWithTax(Cart cart, BigDecimal tax);

    BigDecimal calculateSumWithTaxAndDiscount(Cart cart, BigDecimal tax, BigDecimal discount);
}
