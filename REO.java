/**
 * File: REO.java
 * Description: Represents a Real Estate Owned (REO) property, extending the Residential class with additional attributes specific to REO properties.
 * Instructor's Name: Jeff Light
 * Author: alexisbinch
 * Since: 7/11/24
 */

package RealEstate;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class REO {

    private static final Listings reoListings = new Listings();

    // Hard-coded set of names to be used as bidders
    private static final String[] autoBidders = {
            "Patric Stewart", "Walter Koenig", "William Shatner", "Leonard Nimoy", "DeForect Kelley",
            "James Doohan", "George Takei", "Majel Barrett", "Nichelle Nichol", "Jonathan Frank",
            "Marina Sirtis", "Brent Spiner", "Gates McFadden", "Michael Dorn", "LeVar Burton",
            "Wil Wheaton", "Colm Meaney", "Michelle Forbes"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            int choice = getChoice(scanner, 2);
            switch (choice) {
                case 1:
                    listingsMenu(scanner);
                    break;
                case 2:
                    bidsMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Main Menu:");
        System.out.println("----------------------------------------");
        System.out.println("1. Listings");
        System.out.println("2. Bids");
        System.out.print("\nWhat would you like to do? (1-2):\n");
    }

    private static void listingsMenu(Scanner scanner) {
        while (true) {
            displayListingsMenu();
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return;
            }

            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addListingTypeMenu(scanner);
                    break;
                case 2:
                    showListings();
                    break;
                case 3:
                    autoPopulateListings();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayListingsMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Listings Menu:");
        System.out.println("----------------------------------------");
        System.out.println("1. Add Listing");
        System.out.println("2. Show Listings");
        System.out.println("3. Auto Populate Listings (Dev Tool)");
        System.out.println("ENTER: Exit back to previous menu");
        System.out.print("\nWhat would you like to do? (1-3):\n");
    }

    private static void addListingTypeMenu(Scanner scanner) {
        while (true) {
            displayAddListingTypeMenu();
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return;
            }

            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 2.");
                continue;
            }

            switch (choice) {
                case 1:
                    addHouseMenu(scanner);
                    break;
                case 2:
                    addCondoMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayAddListingTypeMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Add Listing Menu:");
        System.out.println("----------------------------------------");
        System.out.println("1. Add House");
        System.out.println("2. Add Condo");
        System.out.println("ENTER: Exit back to previous menu");
        System.out.print("\nWhat would you like to do? (1-2):\n");
    }

    private static void addHouseMenu(Scanner scanner) {
        System.out.println("Add New House Listing:");
        System.out.print("Please enter the street address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("Please enter the zip code: ");
        String zip = scanner.nextLine();
        System.out.print("Please enter the number of bedrooms: ");
        int bedCount = scanner.nextInt();
        System.out.print("Please enter the number of bathrooms: ");
        double bathCount = scanner.nextDouble();
        System.out.print("Please enter the square footage: ");
        int sqFootage = scanner.nextInt();
        System.out.print("Please enter the size of the yard in acres: ");
        double yardAcres = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        House house = new House(streetAddress, zip, bedCount, bathCount, sqFootage, yardAcres);
        double appraisalPrice = house.calculateAppraisalPrice();
        System.out.printf("Appraisal Price for this property is: $%,.2f\n", appraisalPrice);

        System.out.print("Please enter the List Price for the property: ");
        double listPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        house.setListPrice(listPrice);
        reoListings.addListing(streetAddress, house);

        System.out.println("\nYou have created a new listing!");
        printFormattedListing(house);
    }

    private static void addCondoMenu(Scanner scanner) {
        System.out.println("Add New Condo Listing:");
        System.out.print("Please enter the street address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("Please enter the zip code: ");
        String zip = scanner.nextLine();
        System.out.print("Please enter the number of bedrooms: ");
        int bedCount = scanner.nextInt();
        System.out.print("Please enter the number of bathrooms: ");
        double bathCount = scanner.nextDouble();
        System.out.print("Please enter the square footage: ");
        int sqFootage = scanner.nextInt();
        System.out.print("Please enter the floor level: ");
        int floorLvl = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Condo condo = new Condo(streetAddress, zip, bedCount, bathCount, sqFootage, floorLvl);
        double appraisalPrice = condo.calculateAppraisalPrice();
        System.out.printf("Appraisal Price for this property is: $%,.2f\n", appraisalPrice);

        System.out.print("Please enter the List Price for the property: ");
        double listPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        condo.setListPrice(listPrice);
        reoListings.addListing(streetAddress, condo);

        System.out.println("\nYou have created a new listing!");
        printFormattedListing(condo);
    }

    private static void printFormattedListing(Residential residence) {
        String residenceType = (residence instanceof House) ? "House" : "Condo";
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("Residence Type: %-15s Address: %-25s Zip Code: %s\n", residenceType, residence.getStreetAddress(), residence.getZip());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("Sq Footage: %d\n", residence.getSize());
        System.out.printf("Bedrooms: %d\n", residence.getBeds());
        System.out.printf("Bathrooms: %.1f\n", residence.getBaths());

        if (residence instanceof House house) {
            System.out.printf("Yard Size (Acres): %.2f\n", house.getYardAcres());
        } else {
            Condo condo = (Condo) residence;
            System.out.printf("Floor Level: %d\n", condo.getFloorLvl());
        }

        System.out.println("----------------------------------------");
        System.out.printf("Appraisal Price: $%,.2f\n", residence.calculateAppraisalPrice());
        System.out.printf("List Price: $%,.2f\n", residence.getListPrice());
        System.out.println("----------------------------------------");
    }

    private static void showListings() {
        System.out.println("Current Listings for REO:");
        int listingNo = 1;
        for (String address : reoListings.getListings().keySet()) {
            Residential residence = reoListings.getListings().get(address);
            System.out.println("\nListing No: " + listingNo);
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("Residence Type: " + residence.getClass().getSimpleName() + "\t\tAddress: " + address + "\t\tZip Code: " + residence.getZip());
            System.out.println("-------------------------------------------------------------------------------------------------------");
            if (residence instanceof House house) {
                System.out.println("Sq Footage: " + house.getSize());
                System.out.println("Bedrooms: " + house.getBeds());
                System.out.println("Bathrooms: " + house.getBaths());
                System.out.println("Yard Size (Acres): " + house.getYardAcres());
            } else if (residence instanceof Condo condo) {
                System.out.println("Sq Footage: " + condo.getSize());
                System.out.println("Bedrooms: " + condo.getBeds());
                System.out.println("Bathrooms: " + condo.getBaths());
                System.out.println("Floor: " + condo.getFloorLvl());
            }
            System.out.println("------------------------------------------");
            System.out.printf("Appraisal Price: $%,.2f%n", residence.calculateAppraisalPrice());
            System.out.printf("List Price: $%,.2f%n", residence.getListPrice());
            System.out.println("------------------------------------------");
            listingNo++;
        }
    }

    private static void autoPopulateListings() {
        int currentSize = reoListings.getListings().size();

        House house1 = new House("34 Elm", "95129", 3, 2, 2200, .2);
        house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("34 Elm", house1);

        House house2 = new House("42 Hitchhikers", "95136", 4, 3, 2800, .3);
        house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("42 Hitchhikers", house2);

        Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
        condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("4876 Industrial", condo1);

        House house3 = new House("2654 Oak", "84062", 5, 3, 4200, .5);
        house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("2654 Oak", house3);

        Condo condo2 = new Condo("9875 Lexington", "84063", 2, 1, 1500, 1);
        condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("9875 Lexington", condo2);

        Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
        condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("3782 Market", condo3);

        House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
        house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("7608 Glenwood", house4);

        House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
        house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("1220 Apple", house5);
    }

    private static void bidsMenu(Scanner scanner) {
        while (true) {
            displayBidsMenu();
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return;
            }

            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBid(scanner);
                    break;
                case 2:
                    showBids(scanner);
                    break;
                case 3:
                    autoPopulateBids();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayBidsMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Bids Menu:");
        System.out.println("----------------------------------------");
        System.out.println("1. Add Bid");
        System.out.println("2. Show Bids");
        System.out.println("3. Auto Populate Bids (Dev Tool)");
        System.out.println("ENTER: Exit back to previous menu");
        System.out.print("\nWhat would you like to do? (1-3):\n");
    }

    private static void addBid(Scanner scanner) {
        if (reoListings.getListingCount() == 0) {
            System.out.println("No listings available to add bids.");
            return;
        }

        System.out.println("Current Listings for REO:\n");
        System.out.println("\nNo.      Property(bids)");
        System.out.println("---------------------------");
        listPropertiesWithBidCount();

        System.out.print("ENTER: Exit back to previous menu");
        System.out.print("\nFor which property would you like to add a bid?");

        String listingNo = scanner.nextLine();
        if (listingNo.isEmpty()) {
            return;
        }
        Residential selectedResidence = getResidenceByListingNo(listingNo);
        if (selectedResidence == null) {
            System.out.println("Invalid listing number.");
            return;
        }

        System.out.println("Selected Property:");
        printFormattedListing(selectedResidence);

        System.out.print("Please enter the name of the bidder: ");
        String bidderName = scanner.nextLine();
        System.out.print("Please enter the new bid: ");
        double bidAmount = 0;
        try {
            bidAmount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid bid amount.");
            return;
        }

        selectedResidence.newBid(bidderName, bidAmount);
        System.out.printf("New bid for property '%s' added.%n", selectedResidence.getStreetAddress());
    }

    private static void showBids(Scanner scanner) {
        if (reoListings.getListingCount() == 0) {
            System.out.println("No listings available to show bids.");
            return;
        }

        System.out.println("Select a property to show bids:");
        listPropertiesWithBidCount();

        System.out.print("Enter the listing number: ");
        int listingNo = scanner.nextInt();
        scanner.nextLine();

        Residential selectedResidence = getResidenceByListingNo(String.valueOf(listingNo));
        if (selectedResidence == null) {
            System.out.println("Invalid listing number.");
            return;
        }

        System.out.println("Selected Property:");
        printFormattedListing(selectedResidence);

        System.out.println("Current bids for this listing:");
        System.out.println("---------------------------------------------");
        System.out.println("  Bidder                          Bid");
        System.out.println("---------------------------------------------");
        for (Map.Entry<String, Double> bid : selectedResidence.getBids().entrySet()) {
            System.out.printf("%-30s $%,.2f%n", bid.getKey(), bid.getValue());
        }
        System.out.println("---------------------------------------------");
    }

    private static void autoPopulateBids() {
        Random r = new Random();

        for (Residential residence : reoListings.getResidences()) {
            int bidCount = (int) (Math.random() * 10) + 1;
            double appraisalPrice = residence.calculateAppraisalPrice();
            for (int i = 1; i <= bidCount; i++) {
                int index = r.nextInt(autoBidders.length);
                residence.newBid(autoBidders[index], appraisalPrice * (0.8 + (Math.random() * 0.4)));
            }
        }
        System.out.println("Auto-populated bids for all properties.");
    }

    private static void listPropertiesWithBidCount() {
        int listingNo = 1;
        for (Residential residence : reoListings.getResidences()) {
            System.out.printf("%d:      Address: %s (%d)%n",
                    listingNo, residence.getStreetAddress(), residence.getBidCount());
            listingNo++;
        }
    }

    private static Residential getResidenceByListingNo(String listingNo) {
        int listingNumber;
        try {
            listingNumber = Integer.parseInt(listingNo);
        } catch (NumberFormatException e) {
            return null;
        }

        int currentNo = 1;
        for (Residential residence : reoListings.getResidences()) {
            if (currentNo == listingNumber) {
                return residence;
            }
            currentNo++;
        }
        return null;
    }

    private static int getChoice(Scanner scanner, int max) {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }
}
