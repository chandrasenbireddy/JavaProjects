import java.util.*;

public class ECommerceSystem {
    public static void main(String[] args){
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(1, "Laptop", 999.99, "High performance laptop"));
        catalog.add(new Product(2, "Smartphone", 499.99, "Latest model smartphone"));
        catalog.add(new Product(3, "Headphones", 199.99, "Noise cancelling headphones"));
        catalog.add(new Product(4, "Smartwatch", 149.99, "Feature-rich smartwatch"));
        Set<Integer> validProductIds = new HashSet<>();
        for (Product p: catalog){
            validProductIds.add(p.getId());
        }
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nE-Commerce System Menu:");
            System.out.println("1. View Product Catalog");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Clear Cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Product Catalog:");
                    for (Product product : catalog) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to add to cart: ");
                    int addId = sc.nextInt();
                    sc.nextLine();
                    if (!validProductIds.contains(addId)){
                        System.out.println("Product not found.");
                        break;
                    }
                    Product selected =  catalog.stream().filter(p -> p.getId() == addId).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid Product Id"));
                    cart.addProduct(selected);
                    System.out.println("Quantity: ");
                    int qtyToAdd = sc.nextInt();
                    cart.addProduct(selected, qtyToAdd);
                    System.out.println(selected.getName() + " added to cart.");
                    break;
                case 3:
                    cart.viewCart();
                    System.out.println("Enter Product ID to remove from cart: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Quantity to remove or 1 by default: ");
                    String qtyToRemove = sc.nextLine();
                    Product toRemove = catalog.stream().filter(p -> p.getId() == removeId).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid Product Id"));
                    if (qtyToRemove.isEmpty()) {
                        cart.removeProduct(toRemove);
                        System.out.println("Removed 1 " + toRemove.getName() + " from cart.");
                    }
                    else {
                        cart.removeProduct(toRemove, Integer.parseInt(qtyToRemove));
                    }
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    cart.clearCart();
                    System.out.println("cart cleared.");
                    break;
                case 6:
                    System.out.println("Exiting system. Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        while (choice !=6);
    }
}
