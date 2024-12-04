package src;

public class Product {
    private String name;
    private String description;
    private double price;

    // Constructor
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + "\nDescription: " + description + "\nPrice: $" + price + "\n";
    }
}
