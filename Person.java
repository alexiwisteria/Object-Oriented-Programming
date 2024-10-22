/**
 * File: Person.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a simple class.
 *
 * Constructs:
 * Class Definition - Person
 * LocalDate class
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 *
 *  Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate dob;
    private String gender;
    private String phone;

    public Person() {
        name = "";
        dob = LocalDate.parse("1900-01-01");
        gender = "";
        phone = "";
    }

    public Person(String name, LocalDate dob, String gender, String phone) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setDOB(String dob) {
        this.dob = LocalDate.parse(dob);
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


}
