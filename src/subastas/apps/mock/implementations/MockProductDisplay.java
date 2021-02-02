package subastas.apps.mock.implementations;

import subastas.model.Product;
import subastas.view.ProductDisplay;

public class MockProductDisplay implements ProductDisplay{

    @Override
    public void display(Product product) {
        System.out.println(product.toString());
    }

    @Override
    public void changed() {
        //this.display();
    }
    
}
