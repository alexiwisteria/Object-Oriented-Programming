package DessertShop;

import java.util.ArrayList;

public class Customer {

    // Attributes
    private String custName;
    private ArrayList<Order> orderHistory;
    private int custID;
    private static int nextCustID = 1000;

    // Constructors
    public Customer(String custName) {
        this.custName = custName;
        this.orderHistory = new ArrayList<>();
        this.custID = nextCustID++;
    }

    // Getters & Setters
    public String getName() {
        return custName;
    }

    public int getID(){
        return custID;
    }

    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }

    public void setName(String n){
        custName = n;
    }

    // Method
    public void addToHistory(Order o){
        orderHistory.add(o);
    }
}
