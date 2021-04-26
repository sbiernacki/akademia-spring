package pl.writech.week2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.writech.week2.domain.Cart;
import pl.writech.week2.domain.Product;
import pl.writech.week2.service.CartService;
import pl.writech.week2.service.PriceGenerator;
import pl.writech.week2.service.Shop;

@Service
@Profile("Standard")
public class ShopStandard implements Shop {

    private PriceGenerator priceGenerator;
    private CartService cartService;

    @Autowired
    public ShopStandard(PriceGenerator priceGenerator, CartService cartService) {
        this.priceGenerator = priceGenerator;
        this.cartService = cartService;
    }

    @Override
    public Cart prepareCart() {
        Cart cart = cartService.createCart();
        cart.getProducts().add(new Product("Samochodzik", priceGenerator.generatePrice()));
        cart.getProducts().add(new Product("Rower", priceGenerator.generatePrice()));
        cart.getProducts().add(new Product("Pluszak", priceGenerator.generatePrice()));
        cart.getProducts().add(new Product("Klocki", priceGenerator.generatePrice()));
        return cart;
    }

    @Override
    public void showProductsFromCart(Cart cart) {
        System.out.println("Produkty:");
        cart.getProducts().forEach(System.out::println);
        System.out.println("Suma: " + cartService.calculateSum(cart));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Cart cart = prepareCart();
        showProductsFromCart(cart);
    }
}
