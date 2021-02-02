package subastas.apps.mock.implementations;

import java.util.List;
import subastas.model.Product;
import subastas.view.ActiveAuctionsDisplay;

public class MockActiveAuctionsDisplay implements ActiveAuctionsDisplay{

    @Override
    public void display(List<Product> products) {
        String res = "Active auctions at the moment: \n";
        for (Product product : products) {
            res += product.getName() + "\n";
        }
        System.out.println(res);
    }

    @Override
    public void on(ProductSelected productSelected) {
        System.out.println("\nThe product " + productSelected.getProductName() + " has been selected.\nDisplaying the information about this product:\n");
    }

    @Override
    public void changed() {
        
    }

   
    
}
