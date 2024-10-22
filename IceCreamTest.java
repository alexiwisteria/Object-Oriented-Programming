/**
 * File: IceCreamTest.java
 * Description: This is a test file that tests the getters and setters from IceCreamTest.java
 * Lessons Learned: This project has taught me how to use JUnit 5 to test my code.
 *
 * Constructs:
 * Class Definition - IceCreamTest
 * testGet & testSet Methods - void testGet() {} , void testSet(){}
 * IceCream Object - IceCream iceCream= new IceCream();
 * JUnit Assertions - assertEquals()
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {



    @Test
    void getScoopCount() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        assertEquals(3, iceCream.getScoopCount());
    }

    @Test
    void getPricePerScoop() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        assertEquals(1, iceCream.getPricePerScoop());
    }


    @Test
    void setScoopCount() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        iceCream.setScoopCount(2);
        assertEquals(2, iceCream.getScoopCount());
    }

    @Test
    void setPricePerScoop() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        iceCream.setPricePerScoop(2.50);
        assertEquals(2.50, iceCream.getPricePerScoop());
    }

    @Test
    void calculateCost() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        assertEquals(3.0, iceCream.calculateCost());
    }

    @Test
    void calculateTax() {
        IceCream iceCream = new IceCream("Mint", 3, 1);
        assertEquals(0.21749999999999997, iceCream.calculateTax());
    }
}