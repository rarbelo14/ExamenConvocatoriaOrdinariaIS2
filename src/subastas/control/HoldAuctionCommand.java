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
        System.out.print("Select a product: ");
        String productSelected = keyboard.next();
        for (Product product : products) {
            if(productSelected.equals(product.getName())){
                activeAuctionsDisplay.on(new ProductSelected(product));
                productDisplay.display(product);
                System.out.println("\nDo you want to place a bid on this product? (Yes / No)");
                String wantToPlaceABid = keyboard.next();
                if(wantToPlaceABid.equals("Yes")){
                    System.out.println("How much?");
                    String bidAmount = keyboard.next();
                    int intBidAmount = Integer.parseInt(bidAmount);
                    //MockPlaceABid.bid(product, intBidAmount);
                    
                    /*  
                        Disculpe, pero no sé seguir desde aquí:
                            Me faltó completar la operación de "Realizar una puja", que no sé porqué me está dando error.
                            Y también me faltó el poder hacer que el tiempo de la puja disminuyese con el paso de los minutos.
                            Por último, me faltó terminar de realizar correctamente el patrón Observer.
                    */
                    
                }
            }
        }
    }    
}
