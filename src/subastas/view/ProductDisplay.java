package subastas.view;

import subastas.model.Product;

public interface ProductDisplay extends Product.Observer{
    void display(Product product);
}
