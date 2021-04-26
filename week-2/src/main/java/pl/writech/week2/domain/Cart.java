package pl.writech.week2.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

}
