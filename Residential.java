/**
 * File: Residential.java
 * Description: An abstract class representing residential properties, including common attributes such as bed count, bath count, and square footage.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */
package RealEstate;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable {

    // Attributes
    private int bedCount;
    private double bathCount;
    private int sqFootage;
    private HashMap<String, Double> bids;

    // Constructor
    public Residential() {
        super();
        this.bedCount = 0;
        this.bathCount = 0;
        this.sqFootage = 0;
        this.bids = new HashMap<>();
    }

    public Residential(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage) {
        super(streetAddress, zip);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.sqFootage = sqFootage;
        this.bids = new HashMap<>();
    }

    // Getters & Setters
    public int getBeds() {
        return bedCount;
    }

    public void setBeds(int bedCount) {
        this.bedCount = bedCount;
    }

    public double getBaths() {
        return bathCount;
    }

    public void setBaths(double bathCount) {
        this.bathCount = bathCount;
    }

    public int getSize() {
        return sqFootage;
    }

    public void setSize(int sqFootage) {
        this.sqFootage = sqFootage;
    }



    @Override
    public HashMap<String, Double> getBids() {
        return new HashMap<>(bids);
    }

    @Override
    public Double getBid(String bidderName) {
        return bids.get(bidderName);
    }

    @Override
    public Set<String> getBidders() {
        return bids.keySet();
    }

    @Override
    public int getBidCount() {
        return bids.size();
    }

    @Override
    public void newBid(String bidderName, Double bidAmount) {
        bids.put(bidderName, bidAmount);
    }

    @Override
    public abstract double calculateAppraisalPrice();
}
