package pl.writech.week2.service.impl;

import org.springframework.stereotype.Service;
import pl.writech.week2.domain.Cart;
import pl.writech.week2.domain.Product;
import pl.writech.week2.service.CartService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public Cart createCart() {
        return new Cart();
    }

    @Override
    public BigDecimal calculateSum(Cart cart) {
        return cart.getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateSumWithTax(Cart cart, BigDecimal tax) {
        return cart.getProducts()
                .stream()
                .map(product -> product.getPrice().multiply(BigDecimal.ONE.add(tax)))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateSumWithTaxAndDiscount(Cart cart, BigDecimal tax, BigDecimal discount) {
        return calculateSumWithTax(cart, tax)
                .multiply(BigDecimal.ONE.subtract(discount))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
