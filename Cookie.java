/**
 * File: Cookie.java
 * Description: This file constructs my data class and utilizes setters and getters so that I can input data.
 * Lessons Learned: This project has taught me how to make a subclass.
 *
 * Constructs:
 * Class Definition - Cookie
 * Initializing Constructor
 * Argument Constructor
 * Getter & Setter Methods - public void get() {} , public void set() {}
 *
 * Instructor's Name: Jeff Light
 * @author: Alexis Binch
 * @since: May 8th, 2024
 */

package DessertShop;

public class Cookie extends DessertItem implements SameItem<Cookie> {

// Attributes

    int cookieQty;
    double pricePerDozen;
    double cookiePrice;
    double pricePerCookie;

// Constructors

    Cookie() {
        cookieQty = 0;
        pricePerDozen = 0;
        cookiePrice = 0;
        pricePerCookie = 0;
        setPackaging("");
    }

    Cookie(String name, int cookieQty, double pricePerDozen) {
    super(name);
    this.cookieQty = cookieQty;
    this.pricePerDozen = pricePerDozen;
    this.pricePerCookie = pricePerDozen/12;
    this.cookiePrice = cookiePrice;
    setPackaging("Box");
    }

// Methods

    // Setters & Getters

    //cookieQty
    public int getCookieQty() {
        return cookieQty;
    }
    public void setCookieQty(int cookieQty) {
        this.cookieQty = cookieQty;
    }

    //pricePerDozen
    public double getPricePerDozen() {
        return pricePerDozen;
    }
    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    // Attribute Methods
    public double calculateCost() {
        cookiePrice = pricePerCookie * cookieQty;
        return cookiePrice;
    }

    // Chocolate Chip Macadamia Cookies
    //      5 cookies @ $4.99/dozen:                                                                 $2.08                [Tax: $0.15]

    @Override
    public String toString(){
        return String.format(
                "%s (%s)%n       %d cookies @ $%.2f/dozen:",
                getName(),
                getPackaging(),
                getCookieQty(),
                getPricePerDozen()
        ) +
                String.format(
                        "        $%-10.2f[Tax: $%.2f]%n",
                        calculateCost(),
                        calculateTax()
                );
    }

    @Override
    public boolean isSameAs(Cookie other) {
        return this.getName().equals(other.getName()) && this.pricePerDozen == other.pricePerDozen;
    }


}
