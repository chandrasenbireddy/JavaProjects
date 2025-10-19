import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, CartItem> items = new HashMap<>();
    public void addProduct(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.get(product).increaseQuantity(quantity);
        } else {
            items.put(product, new CartItem(product, quantity));
        }
    }
    public void addProduct(Product product){
        addProduct(product, 1);
    }
    public void removeProduct(Product product, int quantity) {
        if (items.containsKey(product)) {
            CartItem item = items.get(product);
            item.decreaseQuantity(quantity);
            if (item.getQuantity() < 1){
                items.remove(product);
            }
        }
    }
    public void removeProduct(Product product){
        removeProduct(product, 1);
    }
    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getTotalPrice();
        }
        return Math.round(total*100/100.0);
    }
    public void clearCart() {
        items.clear();
    }
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            items.values().forEach(System.out::println);
            System.out.println("Total Price: $" + getTotalPrice());
        }
    }
}
