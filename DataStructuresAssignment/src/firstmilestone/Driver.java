package firstmilestone;

import java.util.Scanner;

/** COPYRIGHT (C) 2023 Supun Wijesooriya. All Rights Reserved.
 * Driver class which acts as the Main class.
 * Solves COMP50004-K-2 - DATABASES AND DATA STRUCTURES II Assignment - Milestone 1
 * @author Supun Wijesooriya
 * @version 1.0 2023-09-25
 */


public class Driver {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        int choice, priority;
        int insertCount = 0;

        do {
            System.out.println("\n<====== Your options list ======>");
            System.out.println("1. Load Goods onto the Van");
            System.out.println("2. Start Deliver");
            System.out.println("3. Display Goods ");
            System.out.println("4. Exit the Program");
            System.out.print("Enter your selection: ");

            // reading user input/choice
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (insertCount >= 13) {
                        System.out.println("\nYou have reached the maximum capacity of the van (13 Packages).");
                        System.out.print("Do you want to start delivering packages to load more packages? (y/n): ");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            priorityQueue.del();
                            insertCount--;
                        } else if (response.equalsIgnoreCase("n")) {
                            // do nothing, allowing the user to continue without deletion
                        } else {
                            System.out.println("Invalid input. Please enter 'y' or 'n'.");
                        }
                    } else {
                        System.out.print("\nEnter Package ID: ");
                        int package_id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String customer_name = scanner.nextLine();
                        System.out.print("Enter Customer ID: ");
                        int customer_id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Weight: ");
                        double weight = scanner.nextDouble();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();

                        Package packageData = new Package(package_id, customer_name, customer_id, address, weight, price);

                        System.out.print("Enter Package's Location ID: ");
                        priority = scanner.nextInt();
                        priorityQueue.insert(packageData, priority);
                        insertCount++;
                        System.out.println("\nOne package loaded to the van successfully.");
                    }
                    break;
                case 2:
                    priorityQueue.del();
                    if (insertCount > 0) {
                        insertCount--;
                    }
                    break;
                case 3:
                    priorityQueue.display();
                    break;
                case 4:
                    try {
                        System.out.println("\nExiting the program......");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid option number. Please follow the instructions.");
            }
        } while (choice != 4);
    }
}

