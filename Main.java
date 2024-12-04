package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cyber Monday Sales:");

        // Create products manually
        Product[] products = {
            new Product("Chocolate", "Delicious dark chocolate for Cyber Monday.", 5.99),
            new Product("Jacket", "Trendy winter jacket.", 49.99),
            new Product("MacBook", "Latest MacBook Pro at an unbeatable price.", 999.99),
            new Product("Mobile", "Smartphone with excellent features.", 299.99)
        };

        // Display product details in the console
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
