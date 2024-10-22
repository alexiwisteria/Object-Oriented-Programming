package RealEstate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CondoTest {

    @Test
    void getFloorLvl() {
        Condo condo = new Condo("123 Main St", "12345",3, 2, 1200,2);
        assertEquals(2, condo.getFloorLvl());
    }

    @Test
    void setFloorLvl() {
        Condo condo = new Condo("123 Main St", "12345",3, 2, 1200,2);
        condo.setFloorLvl(8);
        assertEquals(8, condo.getFloorLvl());
    }
    @Test
    void calculateAppraisalPrice() {
        Condo condo = new Condo("123 Main St", "12345",3, 2, 1200,2);
        assertEquals(445400.0, condo.calculateAppraisalPrice());
    }
}