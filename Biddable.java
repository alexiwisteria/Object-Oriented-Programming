/**
 * File: Biddable.java
 * Description: An interface defining methods for managing a collection of residential property bids, including adding, retrieving, and counting bids.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */

package RealEstate;

import java.util.HashMap;
import java.util.Set;

public interface Biddable {

    HashMap<String, Double> getBids();
    Double getBid(String bidderName);
    Set<String> getBidders();
    int getBidCount();
    void newBid(String bidderName, Double bidAmount);

}
