import java.time.LocalDate;

public class Food extends BaseProduct {
    private final LocalDate expirationDate;

    public Food(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public double getDiscountPercentage() {
        return isEligibleForDiscount() ? 0.1 : 0.0;
    }

    @Override
    boolean isEligibleForDiscount() {
        return expirationDate.minusDays(5).isBefore(LocalDate.now());
    }
}
