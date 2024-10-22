/**
 * File: Candy.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a subclass.
 *
 * Constructs:
 * Class Definition - Candy
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;


public class Candy extends DessertItem implements SameItem<Candy> {

// Attributes

    double candyWeight;
    double pricePerPound;
    double candyPrice;


// Constructors

    Candy() {
        candyWeight = 0;
        pricePerPound = 0;
        candyPrice = 0;
        setPackaging("");
    }


    Candy(String name, double candyWeight, double pricePerPound) {
    super(name);
    this.candyWeight = candyWeight;
    this.pricePerPound = pricePerPound;
    this.candyPrice = candyPrice;
    setPackaging("Bag");
    }

// Methods

    //candyWeight
    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    //pricePerPound
    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    // Attribute Methods
    public double calculateCost() {
        candyPrice = candyWeight * pricePerPound;
        return candyPrice;
    }

    // String.format("Person{name='%s', age=%d, address='%s'}", name, age, address);

    @Override
    public String toString() {
        return String.format(
                "%s (%s)%n      %.2f lbs @ $%.2f/lb.:",
                getName(),
                getPackaging(),
                getCandyWeight(),
                getPricePerPound()
        ) +
                String.format(
                "            $%-10.2f[Tax: $%.2f]%n",
                calculateCost(),
                calculateTax()
        );
    }

    @Override
    public boolean isSameAs(Candy other) {
        return this.getName().equals(other.getName()) && this.pricePerPound == other.pricePerPound;
    }
}
