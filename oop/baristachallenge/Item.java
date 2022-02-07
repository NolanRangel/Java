// Add a constructor to your Item class that takes a String name and  double price as arguments to set the name and price for that object on instantiation.
// Create getters and setters for all the member variables.

public class Item{
    private String name;
    private double price;

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


}
