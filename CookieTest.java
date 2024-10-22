/**
 * File: CookieTest.java
 * Description: This is a test file that tests the getters and setters from Cookie.java
 * Lessons Learned: This project has taught me how to use JUnit 5 to test my code.
 *
 * Constructs:
 * Class Definition - CookieTest
 * testGet & testSet Methods - void testGet() {} , void testSet(){}
 * Cookie Object - Cookie cookie = new Cookie();
 * JUnit Assertions - assertEquals()
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

    @Test
    void getCookieQty() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        assertEquals(24,cookie.getCookieQty());
    }

    @Test
    void getPricePerDozen() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        assertEquals(8.0,cookie.getPricePerDozen());
    }

    @Test
    void setCookieQty() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        cookie.setCookieQty(36);
        assertEquals(36, cookie.getCookieQty());
    }

    @Test
    void setPricePerDozen() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        cookie.setCookieQty(10);
        assertEquals(10, cookie.getCookieQty());
    }

    @Test
    void calculateCost() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        assertEquals(16.0, cookie.calculateCost());
    }

    @Test
    void calculateTax() {
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        assertEquals(1.16, cookie.calculateTax());
    }

    @Test
    void getPackaging(){
        Cookie cookie = new Cookie("Oatmeal", 24, 8);
        assertEquals("Box", cookie.getPackaging());
    }

    @Test
    public void testIsSameAsTrue() {
        Cookie cookie1 = new Cookie("Chocolate Chip",1,3.00);
        Cookie cookie2 = new Cookie("Chocolate Chip", 3, 3.00); // Different qty, same name and price per dozen

        assertTrue(cookie1.isSameAs(cookie2));
    }

    @Test
    public void testIsSameAsFalseDifferentName() {
        Cookie cookie1 = new Cookie("Chocolate Chip",1,8.00);
        Cookie cookie2 = new Cookie("Oatmeal", 1, 8.00); // Different name

        assertFalse(cookie1.isSameAs(cookie2));
    }

    @Test
    public void testIsSameAsFalseDifferentPrice() {
        Cookie cookie1 = new Cookie("Oatmeal",1,8.00);
        Cookie cookie2 = new Cookie("Oatmeal", 1, 12.00); // Different price per dozen

        assertFalse(cookie1.isSameAs(cookie2));
    }

}