public class Electronics extends BaseProduct {
    public Electronics(String name, String brand, double price) {
        super(name, brand, price);
    }

    @Override
    public double getDiscountPercentage() {
        return 0;
    }

    @Override
    boolean isEligibleForDiscount() {
        return false;
    }
}
