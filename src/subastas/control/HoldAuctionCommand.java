package subastas.control;

import java.util.List;
import java.util.Scanner;
import subastas.apps.mock.implementations.MockActiveAuctionsDisplay;
import subastas.apps.mock.implementations.MockPlaceABid;
import subastas.apps.mock.implementations.MockProductDisplay;
import subastas.apps.mock.implementations.MockProductLoader;
import subastas.model.Product;
import subastas.view.ActiveAuctionsDisplay;
import subastas.view.ActiveAuctionsDisplay.ProductSelected;
import subastas.view.PlaceABid;
import subastas.view.ProductDisplay;
import subastas.view.ProductLoader;

public class HoldAuctionCommand implements Command{
    
    private final ProductLoader productLoader;
    private final ActiveAuctionsDisplay activeAuctionsDisplay;
    private final ProductDisplay productDisplay;
    private final PlaceABid placeABid;

    public HoldAuctionCommand() {
        this.activeAuctionsDisplay = new MockActiveAuctionsDisplay();
        this.productLoader = new MockProductLoader();
        this.productDisplay = new MockProductDisplay();
        this.placeABid = new MockPlaceABid();
    }

    @Override
    public void execute() {
        List<Product> products = productLoader.load();
        activeAuctionsDisplay.display(products);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Select a product: ");
        String productSelected = keyboard.next();
        for (Product product : products) {
            if(productSelected == product.getName()){
                activeAuctionsDisplay.on(new ProductSelected(product));
            }
        }        
    }    
}
