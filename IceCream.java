/**
 * File: IceCream.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a subclass.
 *
 * Constructs:
 * Class Definition - IceCream
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

public class IceCream extends DessertItem{

// Attributes

    int scoopCount;
    double pricePerScoop;
    double iceCreamPrice;

// Constructors
    IceCream() {
        scoopCount = 0;
        pricePerScoop = 0.0;
        iceCreamPrice = 0.0;
        setPackaging("");
    }

    IceCream(String name, int scoopCount, double pricePerScoop) {
        super(name);
        this.scoopCount = scoopCount;
        this.pricePerScoop = pricePerScoop;
        this.iceCreamPrice = iceCreamPrice;
        setPackaging("Bowl");
    }

// Methods
    // Setters & Getters

    //scoopCount
    public int getScoopCount() {
        return scoopCount;
    }
    public void setScoopCount(int scoopCount) {
        this.scoopCount = scoopCount;
    }

    //pricePerScoop
    public double getPricePerScoop() {
        return pricePerScoop;
    }
    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    // Attribute Methods
    public double calculateCost() {
        iceCreamPrice = scoopCount * pricePerScoop;
        return iceCreamPrice;
    }

    @Override
    public String toString(){
        return String.format(
                "%s (%s)%n      %d scoops @ $%.2f/scoop:",
                getName(),
                getPackaging(),
                getScoopCount(),
                getPricePerScoop()
        )+
                String.format(
                        "         $%-10.2f [Tax: $%.2f]%n",
                        calculateCost(),
                        calculateTax()
                );
    }

}
