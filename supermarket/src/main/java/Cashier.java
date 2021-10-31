import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cashier {
    public void printReceipt(Cart cart) {
        Map<String, List<BaseProduct>> productGroups = cart.getProducts().stream()
                .collect(Collectors.groupingBy(baseProduct -> baseProduct.getName() + " " + baseProduct.getBrand()));

        for (Map.Entry<String, List<BaseProduct>> productGroup : productGroups.entrySet()) {
            List<BaseProduct> products = productGroup.getValue();
            BaseProduct product = products.get(0);
            System.out.println(productGroup.getKey());
            System.out.println(products.size() + " x " + product.getPrice() + " = " + (products.size() * product.getPrice()));

            List<BaseProduct> discountEligibleProducts = products.stream().filter(BaseProduct::isEligibleForDiscount)
                    .collect(Collectors.toList());
            if (!discountEligibleProducts.isEmpty()) {
                discountEligibleProducts.forEach(currentProduct ->
                        System.out.println("#discount" + " " + currentProduct.getDiscountPercentage()));
                System.out.println("Discount sum: " + discountEligibleProducts.stream()
                        .filter(BaseProduct::isEligibleForDiscount)
                        .mapToDouble(p -> p.getPrice() * p.getDiscountPercentage())
                        .sum());
            }
            System.out.println();
        }

        System.out.println("SUBTOTAL: " + cart.getProducts().stream().mapToDouble(BaseProduct::getPrice).sum());
        System.out.println("DISCOUNT: " + cart.getProducts().stream().mapToDouble(baseProduct -> baseProduct.getPrice() * baseProduct.getDiscountPercentage()).sum());
        System.out.println();
        System.out.println("TOTAL: " + cart.getProducts().stream().mapToDouble(baseProduct -> baseProduct.getPrice() * (1.0 - baseProduct.getDiscountPercentage())).sum());
    }
}
