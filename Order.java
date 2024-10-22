package DessertShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Order implements Payable {
    // Attributes
    private ArrayList<DessertItem> order;
    private double orderPrice;
    private PayType payMethod;
    private String paymentMethod;

    // Constructors
    public Order() {
        order = new ArrayList<>();
        this.payMethod = PayType.CASH;
        this.paymentMethod = payMethod.name();
    }

    // Getters & Setters
    @Override
    public PayType getPayType() {
        return this.payMethod;
    }

    @Override
    public void setPayType(PayType payMethod) {
        this.payMethod = payMethod;
        this.paymentMethod = payMethod.name();
    }

    // Methods
    public ArrayList<DessertItem> getOrderList() {
        return order;
    }

    public DessertItem add(DessertItem item) {
        // Check if item is of type Candy
        if (item instanceof Candy newCandy) {
        for (DessertItem currentItem : order) {
        if (currentItem instanceof Candy existingCandy) {
        if (existingCandy.isSameAs(newCandy)) {
        existingCandy.candyWeight += newCandy.candyWeight;
        return existingCandy;
                    }
                }
            }
        }
        // Check if item is of type Cookie
        else if (item instanceof Cookie newCookie) {
        for (DessertItem currentItem : order) {
        if (currentItem instanceof Cookie existingCookie) {
        if (existingCookie.isSameAs(newCookie)) {
        existingCookie.cookieQty += newCookie.cookieQty;
        return existingCookie;
                    }
                }
            }
        }

        // If not Candy or Cookie, or no match found, add new item
        order.add(item);
        return item;
    }

    public int itemCount() {
        return order.size();
    }

    public double orderCost() {
        double subTotalCost = 0.0;
        for (DessertItem item : order) {
            subTotalCost += item.calculateCost();
        }
        return subTotalCost;
    }

    public double orderTax() {
        double totalTax = 0.0;
        for (DessertItem item : order) {
            totalTax += item.calculateTax();
        }
        return totalTax;
    }

    public void sortItems() {
        Collections.sort(order);
    }

    public void promptForPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("What form of payment will be used? (CASH, CARD, PHONE):");
            String input = scanner.nextLine().toUpperCase();

            try {
                this.payMethod = PayType.valueOf(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("That's not a valid form of payment.");
            }
        }

        this.paymentMethod = this.payMethod.name();
    }

    @Override
    public String toString() {
        StringBuilder finalOutput = new StringBuilder();
        String header = "------------------------Receipt-------------------\n";
        for (DessertItem item : order) {
            finalOutput.append(item.toString()).append("\n");
        }
        String footer = "--------------------------------------------------\n";
        String subTotalPrint = String.format("%s%.2f      [Tax: $%.2f]", "Order Subtotals:                       $", orderCost(), orderTax());
        String totalPrint = String.format("%nOrder Total:                           $%.2f", orderCost() + orderTax());
        String totalCount = String.format("%n%nTotal items in the order: %d%n", itemCount());
        String footer2 = "--------------------------------------------------\n";
        String paymentMethodPrint = String.format("\nPaid for with %s", paymentMethod.toUpperCase());
        return header + finalOutput + footer + subTotalPrint + totalPrint + totalCount + footer2 + paymentMethodPrint;
    }
}
