/**
 * File: Condo.java
 * Description: Extends Residential to represent a condominium, adding an attribute for the floor level and providing an implementation for calculating the appraisal price.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */
package RealEstate;

public class Condo extends Residential {

    // Attributes
    private int floorLvl;
    private double condoCost = 0.0;

    // Constructors
    public Condo() {
        super();
        this.floorLvl = 0;
    }

    public Condo(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage, int floorLvl) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.floorLvl = floorLvl;
    }

    // Setters & Getters
    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    @Override
    public double calculateAppraisalPrice() {
        double sqftCost = getSize() * 88.00;
        double bedCost = getBeds() * 8000;
        double bathCost = getBaths() * 10000;
        double lvlCost = (floorLvl - 1) * 5000;
        condoCost = sqftCost + bedCost + bathCost + lvlCost;
        return condoCost;
    }
}
