/**
 * File: MagelightUniversity.java
 * Description: This is an array list that captures and outputs student information.
 * Lessons Learned: This has shown me how to create a simple array list and how to output the array.
 *
 * Constructs:
 * Class Definition - MagelightUniversity
 * Main Method - public static void main(String[] args){}
 * Array List - ArrayList<> = new ArrayList<>();
 * Person Objects - Person person = new Person();
 * For Loop - for (Person p : people) {}
 * Printing Format Method - printf()
 *
 *  Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

class MagelightUniversity {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<Person>();

        // Creating Person objects and adding them to the ArrayList
        Person st1 = new Person("Rachel", LocalDate.parse("1993-05-12"), "F", "801-555-1212");
        Person st2 = new Person("Jose", LocalDate.parse("2004-12-01"), "M", "480-555-1212");
        Person st3 = new Person("Prya", LocalDate.parse("2001-02-27"), "F", "385-555-1212");
        Person st4 = new Person("Bob", LocalDate.parse("1984-06-06"), "M", "916-555-1212");

        people.add(st1);
        people.add(st2);
        people.add(st3);
        people.add(st4);

        // Getting the current date
        LocalDate currentDate = LocalDate.now();

        // Printing the header for the data
        System.out.printf("%-20s %-8s %-10s %-15s%n", "Name", "Age", "Gender", "Phone Number");
        System.out.println("----------------------------------------------------------");

        // Printing the data
        for (Person p : people) {
            // Calculating age using Period between date of birth and current date
            Period age = Period.between(p.getDOB(), currentDate);
            // Printing each person's information
            System.out.printf("%-20s %-8d %-10s %-15s%n", p.getName(), age.getYears(), p.getGender(), p.getPhone());
        }
    }
}

