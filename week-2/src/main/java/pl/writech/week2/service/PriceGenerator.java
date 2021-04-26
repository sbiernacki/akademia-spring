package pl.writech.week2.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@Service
public class PriceGenerator {

    private static final Integer PRICE_VALUE_MIN = 50;

    private static final Integer PRICE_VALUE_MAX = 300;


    public BigDecimal generatePrice() {
        return  new BigDecimal(BigInteger.valueOf(new Random().nextInt(PRICE_VALUE_MAX - PRICE_VALUE_MIN) * 10L), 2);
    }
}
