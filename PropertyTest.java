package RealEstate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    @Test
    void getStreetAddress() {
        House house = new House("123 Main St", "12345", 3, 2, 1200, 2.5);
        assertEquals("123 Main St", house.getStreetAddress());
    }

    @Test
    void setStreetAddress() {
        House house = new House("123 Main St", "12345", 3, 2, 1200, 2.5);
        house.setStreetAddress("456 Elm St");
        assertEquals("456 Elm St", house.getStreetAddress());
    }

    @Test
    void getZip() {
        House house = new House("123 Main St", "12345", 3, 2, 1200, 2.5);
        assertEquals("12345", house.getZip());
    }

    @Test
    void setZip() {
        House house = new House("123 Main St", "12345", 3, 2, 1200, 2.5);
        house.setZip("67890");
        assertEquals("67890", house.getZip());
    }
}
