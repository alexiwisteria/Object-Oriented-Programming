/**
 * File: DessertItem.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a Superclass.
 *
 * Constructs:
 * Class Definition - Person
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 * Instructor's Name: Jeff Light
 * @authored: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

public abstract class DessertItem implements Packable, Comparable<DessertItem> {

    // Attributes
    private String name;
    private double taxPercent = 7.25;
    private String packaging;

// Constructors

    DessertItem(){
        name = "";
    }

    DessertItem(String name){
        this.name = name;
    }

// Methods

    // Setters and Getters

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Tax Percent
    public double getTaxPercent() {
        return taxPercent;
    }
    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }
    // Packaging
    public String getPackaging() {
        return packaging;
    }
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    // Attribute Methods
    public abstract double calculateCost();

    public double calculateTax(){
        return calculateCost() * (taxPercent / 100.0);
    }

    @Override
    public int compareTo(DessertItem other) {
        if (this.calculateCost() < other.calculateCost()) {
            return -1;
        } else if (this.calculateCost() > other.calculateCost()) {
            return 1;
        } else {
            return 0;
        }
    }
}
