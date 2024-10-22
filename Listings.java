/**
 * File: Listings.java
 * Description: Implements the Listable interface, managing a collection of residential property listings stored in a HashMap with street addresses as keys.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */
package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Listings implements Listable {

    // Attributes
    private HashMap<String, Residential> listings;

    // No-argument constructor
    public Listings() {
        this.listings = new HashMap<>();
    }

    // Methods
    @Override
    public HashMap<String, Residential> getListings() {
        return new HashMap<>(listings);
    }

    @Override
    public Residential getListing(String address) {
        return listings.get(address);
    }

    @Override
    public Set<String> getStreetAddresses() {
        return new HashSet<>(listings.keySet());
    }

    @Override
    public Collection<Residential> getResidences() {
        return listings.values();
    }

    @Override
    public int getListingCount() {
        return listings.size();
    }

    @Override
    public void addListing(String address, Residential residence) {
        listings.put(address, residence);
    }
}
