/**
 * File: House.java
 * Description: Extends Residential to represent a house, adding an attribute for yard size and providing an implementation for calculating the appraisal price.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */
package RealEstate;

public class House extends Residential {

    // Attributes
    private double yardAcres;
    private double houseCost = 0.0;

    // Constructors
    public House() {
        super();
        this.yardAcres = 0;
    }

    public House(String streetAddress, String zip, int bedCount, double bathCount, int sqFootage, double yardAcres) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.yardAcres = yardAcres;
    }

    // Setters & Getters
    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    @Override
    public double calculateAppraisalPrice() {
        double sqftCost = getSize() * 97.00;
        double bedCost = getBeds() * 10000;
        double bathCost = getBaths() * 12000;
        double yardCost = yardAcres * 460000;
        houseCost = sqftCost + bedCost + bathCost + yardCost;
        return houseCost;
    }
}
