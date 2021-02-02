package subastas.apps.mock.implementations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import subastas.model.Product;
import subastas.view.ProductLoader;

public class MockProductLoader implements ProductLoader{

    @Override
    public List<Product> load() {
        List<Product> list = new ArrayList<>();
        List<String> imagesName1 = new ArrayList<>();
        imagesName1.add("Image 1");
        imagesName1.add("Image 2");
        imagesName1.add("Image 3");
        list.add(new Product("Sculpture", "Una escultura muy bonita", imagesName1, 50, 50, 120));
        List<String> imagesName2 = new ArrayList<>();
        imagesName2.add("Image 1");
        imagesName2.add("Image 2");
        list.add(new Product("MacBookPro", "Un ordenador especial para creadores de contenido", imagesName2, 1000, 1000, 60));
        return list;
    }
    
}
