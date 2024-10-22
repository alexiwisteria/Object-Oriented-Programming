/**
 * File: Listable.java
 * Description: An interface defining methods for managing a collection of residential property listings, including adding, retrieving, and counting listings.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */
package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    HashMap<String, Residential> getListings();
    Residential getListing(String address);
    Set<String> getStreetAddresses();
    Collection<Residential> getResidences();
    int getListingCount();
    void addListing(String address, Residential residence);
}
