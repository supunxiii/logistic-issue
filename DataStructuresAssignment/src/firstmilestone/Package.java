package firstmilestone;

public class Package {
    private int package_id;
    private String customer_name;
    private int customer_id;
    private String address;
    private double weight;
    private double price;

    public Package(int package_id, String customer_name, int customer_id, String address, double weight, double price) {
        this.package_id = package_id;
        this.customer_name = customer_name;
        this.customer_id = customer_id;
        this.address = address;
        this.weight = weight;
        this.price = price;
    }

    // getters for package data
    public int getPackage_id() {
        return package_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getAddress() {
        return address;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}

