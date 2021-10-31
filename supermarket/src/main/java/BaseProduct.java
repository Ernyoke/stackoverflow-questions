public abstract class BaseProduct {
    public BaseProduct(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    private final String name;
    private final String brand;
    private final double price;

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    abstract public double getDiscountPercentage();

    abstract boolean isEligibleForDiscount();
}
