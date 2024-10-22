/*
  * File: CandyTest.java
  * Description: This is a test file that tests the getters and setters from Candy.java
  * Lessons Learned: This project has taught me how to use JUnit 5 to test my code.
  *
  * Constructs:
  * Class Definition - CandyTest
  * testGet & testSet Methods - void testGet() {} , void testSet(){}
  * Candy Object - Candy candy = new Candy();
  * JUnit Assertions - assertEquals()
  *
  * Instructor's Name: Jeff Light
  * @author: Alexis Binch
  * @since: May 8th, 2024
  */

package DessertShop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class CandyTest {

        @Test
        void getCandyWeight() {
            Candy candy = new Candy("Snickers",1,3.00);
            assertEquals(1, candy.getCandyWeight());
        }

        @Test
        void getPricePerPound() {
            Candy candy = new Candy("Snickers",1,3.00);
            assertEquals(3.00, candy.getPricePerPound());
        }

        @Test
        void setCandyWeight() {
            Candy candy = new Candy("Snickers", 1,3.00);
            candy.setCandyWeight(5);
            assertEquals(5, candy.getCandyWeight());
        }

        @Test
        void setPricePerPound() {
            Candy candy = new Candy("Snickers",1,3.00);
            candy.setPricePerPound(5);
            assertEquals(5, candy.getPricePerPound());
        }

        @Test
         void calculateCost() {
            Candy candy = new Candy("Snickers",1,3.00);
            assertEquals(3.00, candy.calculateCost());
        }

        @Test
        void calculateTax() {
            Candy candy = new Candy("Snickers",1,3.00);
            assertEquals(0.21749999999999997, candy.calculateTax());
        }

        @Test
        void getPackaging() {
            Candy candy = new Candy("Snickers",1,3.00);
            assertEquals("Bag",candy.getPackaging());
        }

        @Test
        public void testIsSameAsTrue() {
            Candy candy1 = new Candy("Snickers",1,3.00);
            Candy candy2 = new Candy("Snickers", 3.0, 3.00); // Different weight, same name and price per pound

            assertTrue(candy1.isSameAs(candy2));
        }

        @Test
        public void testIsSameAsFalseDifferentName() {
            Candy candy1 = new Candy("Snickers", 2.0, 10.0);
            Candy candy2 = new Candy("Reese's", 2.0, 10.0); // Different name

            assertFalse(candy1.isSameAs(candy2));
        }

        @Test
        public void testIsSameAsFalseDifferentPrice() {
            Candy candy1 = new Candy("Snickers", 2.0, 10.0);
            Candy candy2 = new Candy("Snickers", 2.0, 12.0); // Different price per pound

            assertFalse(candy1.isSameAs(candy2));
        }
}