package subastas.view;

import subastas.model.Product;

public interface PlaceABid {
    void bid(Product product, int amount);
}
