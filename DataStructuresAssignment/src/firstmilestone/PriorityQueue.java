package firstmilestone;

public class PriorityQueue {
    Node front;

    public PriorityQueue() {
        front = null;
    }

    // enqueue method
    public void insert(Package packageData, int priority) {
        Node temp = new Node(packageData, priority);

        // check if the queue is empty or the new element has higher priority
        if (front == null || priority < front.priority) {
            temp.link = front;
            front = temp;
        } else {
            Node q = front;
            while (q.link != null && q.link.priority <= priority) {
                q = q.link;
            }
            temp.link = q.link;
            q.link = temp;
        }
    }

    // dequeue method
    public void del() {
        if (front == null) {
            System.out.println("\nAll packages have been delivered. Please return to the warehouse to pick up more packages."); // Queue Underflow
            try {
                System.out.println("Re-routing back to warehouse......");
                Thread.sleep(3166);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Node temp = front;
            Package packageData = temp.info;
            System.out.println("\nPackage (Package ID: " + packageData.getPackage_id() + ") is now being unloaded and delivered successfully.");
            try {
                System.out.println("Generating an invoice......");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n<====== " + packageData.getCustomer_name() + "'s Invoice - Customer ID: " + packageData.getCustomer_id() + " ======>");
            System.out.printf("Package ID: %d \nCustomer Name: %s \nCustomer ID: %d \nAddress: %s \nWeight: %.2f kg \nPrice: GBP %.2f\n",
                    packageData.getPackage_id(), packageData.getCustomer_name(), packageData.getCustomer_id(),
                    packageData.getAddress(), packageData.getWeight(), packageData.getPrice());
            System.out.println("<=============  =============>");
            front = front.link;
            temp = null;
        }
    }

    // display method
    public void display() {
        Node ptr = front;
        if (front == null) {
            System.out.println("\nCurrently, the van is empty. To load packages onto the van, follow the instructions.");
        } else {
            System.out.println("\nPackage(s) in the van:");
            System.out.println("\nLocation ID       Package Data");
            while (ptr != null) {
                System.out.printf("%5d        ", ptr.priority);
                Package packageData = ptr.info;
                System.out.printf("Package ID: %d, Customer Name: %s, Customer ID: %d, Address: %s, Weight: %.2f kg, Price: GBP %.2f\n",
                        packageData.getPackage_id(), packageData.getCustomer_name(), packageData.getCustomer_id(),
                        packageData.getAddress(), packageData.getWeight(), packageData.getPrice());
                ptr = ptr.link;
            }
        }
    }
}

