package RealEstate;

public abstract class Property {
    // Attributes

    private String streetAddress;
    private String zip;
    private double listPrice = 0.0;
    private double appraisalPrice = 0.0;

    // Constructors

    // A default constructor with no arguments
    public Property() {
       this.streetAddress = "";
       this.zip = "";
    }

    // A full argument constructor that accepts all possible arguments for the class
    public Property(String streetAddress, String zip) {
        this.streetAddress = streetAddress;
        this.zip = zip;
    }

    // Setters & Getters

    // streetAddress
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // zip
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getListPrice() {
        return listPrice;
    }
    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }
    public double getAppraisalPrice() {
        return appraisalPrice;
    }
    protected void setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }

    public abstract double calculateAppraisalPrice();


}
