package secondmilestone;

import java.util.*;

/** COPYRIGHT (C) 2023 Supun Wijesooriya. All Rights Reserved.
 * Driver class which acts as the Main class.
 * Solves COMP50004-K-2 - DATABASES AND DATA STRUCTURES II Assignment - Milestone 2
 * @author Supun Wijesooriya
 * @version 1.0 2023-09-25
 */

public class Driver {
    public static void main(String[] args) {

        // creating nodes for delivery locations
        Node<String> nodeA = new Node<>("WAREHOUSE");
        Node<String> nodeB = new Node<>("Stoke-on-Trent");
        Node<String> nodeC = new Node<>("Stafford");
        Node<String> nodeD = new Node<>("Lichfield");
        Node<String> nodeE = new Node<>("Tamworth");
        Node<String> nodeF = new Node<>("Cannock");

        // add adjacent nodes and weights or in other words, simulating a delivery location map
        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        // creating an instance of the Dijkstra class
        Dijkstra<String> dijkstra = new Dijkstra<>();

        // storing the shortest path data
        List<Node<String>> shortestPaths = dijkstra.calculateShortestPath(nodeA);

        // sort the nodes by distance (ascending order)
        List<Node<String>> sortedNodes = dijkstra.sortNodesByDistance(shortestPaths);

        // create a new scanner object
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n<====== Your options list ======>");
            System.out.println("1. Display All the Shortest Delivery Paths");
            System.out.println("2. Display All the Delivery Locations");
            System.out.println("3. Save Data to the Backup");
            System.out.println("4. Display Van Schedule");
            System.out.println("5. Exit the Program");
            System.out.print("Enter your selection: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (shortestPaths == null) {
                        System.out.println("\nFirst, add data to your delivery location map. Then proceed with the program.");
                    } else {
                        // outputs the sorted nodes with their paths
                        System.out.println("\n");
                        dijkstra.printPaths(sortedNodes);
                    }
                    break;
                case 2:
                    if (shortestPaths == null) {
                        System.out.println("\nFirst, add data to your delivery location map. Then proceed with the program.");
                    } else {
                        // print all nodes except the source node, hence it is not a delivery location
                        System.out.println("\n");
                        dijkstra.printAllNodes(sortedNodes);
                    }
                    break;
                case 3:
                    // save data to a file to act as a backup
                    if (shortestPaths != null) {
                        dijkstra.savePathsToFile(shortestPaths, "backup_co-ordinates.txt");
                    } else {
                        System.out.println("\nFirst, add data to your delivery location map. Then proceed with the program.");
                    }
                    break;
                case 4:
                    // read and output categorized paths from the backup file
                    System.out.println("\n<============= THE CURRENT VAN DELIVERY SCHEDULE =============>");
                    System.out.println("\n");
                    dijkstra.readPathsFromFile("backup_co-ordinates.txt");
                    System.out.println("\n<=============  =============>");
                    break;
                case 5:
                    try {
                        System.out.println("\nExiting the program......");
                        Thread.sleep(2000);
                        scanner.close();
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("\nInvalid option number. Please follow the instructions.");
            }
        }
    }
}
