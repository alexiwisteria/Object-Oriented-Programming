package DessertShop;

import java.util.HashMap;
import java.util.Scanner;

public class DessertShop extends Sundae {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Customer> customerDB = new HashMap<>();

    private static DessertItem userPromptCandy() {
        System.out.println("Enter the type of candy:");
        String name = scanner.nextLine();
        System.out.println("Enter the weight (lbs) requested:");
        double candyWeight = scanner.nextDouble();
        System.out.println("Enter the price per lbs:");
        double pricePerPound = scanner.nextDouble();

        scanner.nextLine();

        return new Candy(name, candyWeight, pricePerPound);
    }

    private static DessertItem userPromptCookie() {
        System.out.println("Enter the type of cookie:");
        String name = scanner.nextLine();
        System.out.println("Enter the number of cookies:");
        int cookieQty = scanner.nextInt();
        System.out.println("Enter the price per dozen:");
        double pricePerDozen = scanner.nextDouble();

        scanner.nextLine();

        return new Cookie(name, cookieQty, pricePerDozen);
    }

    private static DessertItem userPromptIceCream() {
        System.out.println("Enter the type of ice cream:");
        String name = scanner.nextLine();
        System.out.println("Enter the number of scoops:");
        int scoopCount = scanner.nextInt();
        System.out.println("Enter the price per scoop:");
        double pricePerScoop = scanner.nextDouble();

        scanner.nextLine();

        return new IceCream(name, scoopCount, pricePerScoop);
    }

    private static DessertItem userPromptSundae() {
        System.out.println("Enter the type of ice cream:");
        String name = scanner.nextLine();
        System.out.println("Enter the number of scoops:");
        int scoopCount = scanner.nextInt();
        System.out.println("Enter the price per scoop:");
        double pricePerScoop = scanner.nextDouble();
        System.out.println("Enter the type of topping:");
        scanner.nextLine(); // Consume newline
        String toppingName = scanner.nextLine();
        System.out.println("Enter the price of the topping:");
        double toppingPrice = scanner.nextDouble();

        scanner.nextLine();

        return new Sundae(name, scoopCount, pricePerScoop, toppingName, toppingPrice);
    }

    // main method
    public static void main(String[] args) {
        Scanner sIn = new Scanner(System.in);
        String choice;
        DessertItem orderItem;

        while (true) {
            Order o1 = new Order();
            boolean done = false;
            while (!done) {
                System.out.println("\n1: Candy");
                System.out.println("2: Cookie");
                System.out.println("3: Ice Cream");
                System.out.println("4: Sundae");

                System.out.print("\nWhat would you like to add to the order? (1-4, Enter for done): ");
                choice = sIn.nextLine();

                if (choice.equals("")) {
                    done = true;
                } else {
                    switch (choice) {
                        case "1":
                            orderItem = userPromptCandy();
                            o1.add(orderItem);
                            break;
                        case "2":
                            orderItem = userPromptCookie();
                            o1.add(orderItem);
                            break;
                        case "3":
                            orderItem = userPromptIceCream();
                            o1.add(orderItem);
                            break;
                        case "4":
                            orderItem = userPromptSundae();
                            o1.add(orderItem);
                            break;
                    }
                }
            }

            // Prompt for customer name
            System.out.println("Enter the customer's name:");
            String customerName = sIn.nextLine();
            Customer customer;
            if (customerDB.containsKey(customerName)) {
                customer = customerDB.get(customerName);
            } else {
                customer = new Customer(customerName);
                customerDB.put(customerName, customer);
            }
            customer.addToHistory(o1);

            // Adds the following items to the order
            Candy candyCorn = new Candy("Candy Corn", 1.5, .25);
            Candy gummyBears = new Candy("Gummy Bears", .25, .35);
            o1.add(candyCorn);
            o1.add(gummyBears);
            Cookie chocolateChip = new Cookie("Chocolate Chip", 6, 3.99);
            Cookie oatmealRaisin = new Cookie("Oatmeal Raisin", 2, 3.45);
            o1.add(chocolateChip);
            o1.add(oatmealRaisin);
            IceCream pistachio = new IceCream("Pistachio", 2, .79);
            o1.add(pistachio);
            Sundae vanilla = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
            o1.add(vanilla);

            // Sort items in the order
            o1.sortItems();

            // Prompt user for payment method
            o1.promptForPaymentMethod();

            // Print receipt
            System.out.println(o1);

            // Print customer info
            System.out.println("---------------------------------------------------------------------------");
            System.out.printf("Customer Name: %s           Customer ID: %d           Total Orders: %d\n",
                    customer.getName(), customer.getID(), customer.getOrderHistory().size());

            // Ask the user to hit enter to start a new order
            System.out.println("Hit enter to start a new order.");
            sIn.nextLine();
        }
    }
}
