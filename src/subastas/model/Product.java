package subastas.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String name;
    private final Description description;
    private final int startingPrice;
    private int currentBid;
    private int minutesRemaining;
    private final List<Observer> observers;

    public Product(String name, String description, List<String> imagesName, int startingPrice, int currentBid, int minutes) {
        this.name = name;
        List<Image> images = new ArrayList<>();
        for (String imageName : imagesName) {
            images.add(new Image(imageName));
        }
        this.description = new Description(description, images);
        this.startingPrice = startingPrice;
        this.currentBid = currentBid;
        this.minutesRemaining = minutes;
        this.observers = new ArrayList<>();
    }
    
    public void register(Observer observer){
        this.observers.add(observer);
    }

    public String getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public int getMinutesRemaining() {
        return minutesRemaining;
    }

    @Override
    public String toString() {
        String res = "This poduct is called " + this.name + ".";
        res += "\nDescription: " + description.getText() + ".";
        res += "\nImages of the product: " + description.ImagestoString() + ".";
        res += "\nThe starting price of this product is " + startingPrice + " €.";
        res += "\nThe current bid for this product is " + this.currentBid + " €.";
        res += "\nThe minutes remaining for the auction of this product are " + this.minutesRemaining + " minutes.";
        return res;
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) observer.changed();
    }
    
    public interface Observer{
        void changed();
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
        this.notifyObservers();
    }
    
    public void reduceMinutes(){
        if(minutesRemaining > 0)minutesRemaining--;
        if(minutesRemaining == 0) this.notifyObservers(); 
    }

}
