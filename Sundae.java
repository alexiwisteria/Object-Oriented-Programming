/**
 * File: Sundae.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a subclass.
 *
 * Constructs:
 * Class Definition - Sundae
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */
package DessertShop;

public class Sundae extends IceCream{

// Attributes

    String toppingName;
    double toppingPrice;
    double sundaePrice;


// Constructors

    Sundae(){
        toppingName = "";
        toppingPrice = 0.0;
        sundaePrice = 0.0;
        setPackaging("");
    }

    Sundae(String name, int scoopCount, double pricePerScoop, String toppingName, double toppingPrice) {
        super(name, scoopCount, pricePerScoop);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.sundaePrice = 0.0;
        setPackaging("Boat");
    }

// Methods

    // Setters & Getters

    //toppingName
    public String getToppingName() {
        return toppingName;
    }
    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    //toppingPrice
    public double getToppingPrice() {
        return toppingPrice;
    }
    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    // Attribute Methods
    @Override
    public double calculateCost() {
        sundaePrice = scoopCount * pricePerScoop + toppingPrice;
        return sundaePrice;
    }

    @Override
    public String toString(){
        return String.format("%s (%s)%n       %d scoops @ $%.2f/scoop%n       %s topping @ $%.2f:",
                getName(),
                getPackaging(),
                getScoopCount(),
                getPricePerScoop(),
                getToppingName(),
                getToppingPrice()
        )+
                String.format(
                        "      $%-10.2f [Tax: $%.2f]%n",
                        calculateCost(),
                        calculateTax()
                );
    }

}
