// Add a constructor to your Item class that takes a String name and  double price as arguments to set the name and price for that object on instantiation.
// Create getters and setters for all the member variables.
import java.util.ArrayList;


public class Item{
    private String name;
    private double price;
    private int index;

    public Item(){}

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // getter
    public String getName(){
        return this.name;
    }
    // setter
    public void setName(String name){
        this.name = name;
    }


    // getter
    public double getPrice(){
        return this.price;
    }
    // setter
    public void setPrice(double price){
        this.price = price;
    }


    // getter
    public int getIndex(){
        return this.index;
    }
    // setter
    public void setIndex(int index){
        this.index = index;
    }


}
