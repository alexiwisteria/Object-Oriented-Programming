package DessertShop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CustomerTest {

    @Test
    void getName() {
        Customer customer = new Customer("John Doe");
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void getID() {
        Customer customer = new Customer("John Doe");
        assertTrue(customer.getID() >= 1000); // Assuming ID starts from 1000 and increments
    }

    @Test
    void getOrderHistory() {
        Customer customer = new Customer("John Doe");
        assertNotNull(customer.getOrderHistory());
        assertTrue(customer.getOrderHistory().isEmpty());
    }

    @Test
    void setName() {
        Customer customer = new Customer("John Doe");
        customer.setName("Jane Smith");
        assertEquals("Jane Smith", customer.getName());
    }

    @Test
    void addToHistory() {
        Customer customer = new Customer("John Doe");
        Order order = new Order();
        customer.addToHistory(order);
        assertEquals(1, customer.getOrderHistory().size());
        assertEquals(order, customer.getOrderHistory().get(0));
    }
}
