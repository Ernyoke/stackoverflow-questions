import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    List<BaseProduct> products = new ArrayList<>();

    public void addProduct(BaseProduct product) {
        products.add(product);
    }

    public List<BaseProduct> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
