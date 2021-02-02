package subastas.apps.mock.implementations;

import subastas.model.Product;
import subastas.view.PlaceABid;

public class MockPlaceABid implements PlaceABid{

    @Override
    public void bid(Product product, int amount) {
        if(amount > product.getCurrentBid()){
            product.setCurrentBid(amount);
            product.notifyObservers();
        }
    }
    
}
