import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct(new Food("cheese", "Cheese", 10.0, LocalDate.of(2021, 11, 1)));
        cart.addProduct(new Food("cheese", "Cheese", 10.0, LocalDate.of(2021, 11, 20)));
        cart.addProduct(new Food("vine", "Vine", 50.0, LocalDate.of(2025, 10, 1)));
        cart.addProduct(new Electronics("phone", "iPhone", 1000.0));
        cart.addProduct(new Electronics("laptop", "MacBook Air", 1200.0));

        Cashier cashier = new Cashier();
        cashier.printReceipt(cart);
    }
}
