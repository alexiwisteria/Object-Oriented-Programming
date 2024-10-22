/**
 * File: PersonTest.java
 * Description: This is a test file that tests the getters and setters from Person.java
 * Lessons Learned: This project has taught me how to use JUnit 5 to test my code.
 *
 * Constructs:
 * Class Definition - PersonTest
 * testGet & testSet Methods - void testGet() {} , void testSet(){}
 * Person Objects - Person person = new Person();
 * JUnit Assertions - assertEquals()
 *
 *  Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    // Getter Tests

    @Test
    void testGetName() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        assertEquals("Alexis Binch", person.getName());
    }

    @Test
    void testGetDOB() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        assertEquals(LocalDate.parse("2001-03-05"), person.getDOB());
    }

    @Test
    void testGetGender() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        assertEquals("Female", person.getGender());
    }

    @Test
    void testGetPhone() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        assertEquals("4802785787", person.getPhone());
    }

    // Setter Test

    @Test
    public void testSetName() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        person.setName("Alexis Binch");
    }

    @Test
    public void testSetDOB() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        person.setDOB("2001-03-05");
    }

    @Test
    public void testSetGender() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        person.setGender("Female");
    }

    @Test
    public void testSetPhone() {
        Person person = new Person("Alexis Binch", LocalDate.parse("2001-03-05"), "Female", "4802785787");
        person.setPhone("4802785787");
    }
}