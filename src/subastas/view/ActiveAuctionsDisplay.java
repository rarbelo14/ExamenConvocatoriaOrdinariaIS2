package subastas.view;

import java.util.List;
import subastas.model.Product;

public interface ActiveAuctionsDisplay extends Product.Observer{
    void display(List<Product> products);
    void on(ProductSelected productSelected);

    public static class ProductSelected {
        private final Product product;
        public ProductSelected(Product product) {
            this.product = product;
        }

        public String getProductName() {
            return product.getName();
        }
        
    }
}
