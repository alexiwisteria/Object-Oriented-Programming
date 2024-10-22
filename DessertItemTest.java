package DessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DessertItemTest {

    @Test
    void getName() {
        Candy candy = new Candy("Snickers",1,3.00);
        assertEquals("Snickers", candy.getName());
    }

    @Test
    void setName() {
        Candy candy = new Candy("Snickers",1,3.00);
        candy.setName("Twix");
        assertEquals("Twix", candy.getName());
    }

    @Test
    void getTaxPercent() {
        Candy candy = new Candy("Snickers",1,3.00);
        assertEquals(7.25, candy.getTaxPercent());
    }

    @Test
    void setTaxPercent() {
        Candy candy = new Candy("Snickers",1,3.00);
        candy.setTaxPercent(5);
        assertEquals(5, candy.getTaxPercent());
    }

    @Test
    void setPackaging() {
        Candy candy = new Candy("Snickers",1,3.00);
        candy.setPackaging("packaging");
        assertEquals("packaging", candy.getPackaging());
    }

}