package RealEstate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void testGetYardAcres() {
        House house = new House("123 Main St", "12345",3, 2, 1200,2.5);
        assertEquals(2.5, house.getYardAcres());
    }

    @Test
    void testSetYardAcres() {
        House house = new House("123 Main St", "12345",3, 2, 1200,2.5);
        house.setYardAcres(3.5);
        assertEquals(3.5, house.getYardAcres());
    }

    @Test
    void calculateAppraisalPrice() {
        House house = new House("123 Main St", "12345",3, 2, 1200,2.5);
        assertEquals(1590400.0, house.calculateAppraisalPrice());
    }



}