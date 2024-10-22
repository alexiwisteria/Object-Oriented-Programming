/**
 * File: SundaeTest.java
 * Description: This is a test file that tests the getters and setters from Sundae.java
 * Lessons Learned: This project has taught me how to use JUnit 5 to test my code.
 *
 * Constructs:
 * Class Definition - SundaeTest
 * testGet & testSet Methods - void testGet() {} , void testSet(){}
 * Sundae Object - Sundae sundae = new Sundae();
 * JUnit Assertions - assertEquals()
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SundaeTest {

    @Test
    void getToppingName() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        assertEquals("Chocolate Sauce", sundae.getToppingName());
    }

    @Test
    void getToppingPrice() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        assertEquals(0.25, sundae.getToppingPrice(), 0);

    }

    @Test
    void setToppingName() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        sundae.setToppingName("Peanuts");
        assertEquals("Peanuts", sundae.getToppingName());
    }

    @Test
    void setToppingPrice() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        sundae.setToppingPrice(0.30);
        assertEquals(0.30, sundae.getToppingPrice(), 0);
    }

    @Test
    void calculateCost() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        assertEquals(3.25, sundae.calculateCost());
    }

    @Test
    void calculateTax() {
        Sundae sundae = new Sundae("Banana Split", 3, 1,"Chocolate Sauce",0.25);
        assertEquals(0.23562499999999997, sundae.calculateTax());
    }
}