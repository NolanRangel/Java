// Private Member Variables:
// Set the member variables to private instead of  public.
// This time do not include the total member variable, as we will be using a method for getting the total.

// Constructor: 
// Add a constructor to your Order class that takes no arguments, but sets the name to "Guest" and initializes the items array to an empty ArrayList<Item> 

// Overloaded Constructor: 
// Add an overloaded constructor for Order that takes String name as an argument, so you can create an instance with a name.

// Accessors & Mutators (Getters and Setters)
// Create getters and setters for all the member variables, using good naming convention for boolean accessors.

import java.util.ArrayList;


public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();
    public Orders(){
        this.name = "Guest";
        this.ready = false;
    }
    public Orders(String name){
        this.name = name;
        this.ready = false;
    }

    public String getName(){
        return this.name;
    }
    public void  setName(String name){
        this.name = name;
    }


    public boolean getReady(){
        return this.ready;
    }
    public void  setReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }


    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready == true) {
            return "Your order is ready";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

    public double getOrderTotal(){
        double total = 0.0;

        for(Item i : this.items){
            total += i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: " + this.name);
        for(Item i : this.items) {
            System.out.println(i.getName() + " - " + i.getPrice());
        }
        System.out.println("Total: " + this.getOrderTotal());

    }

    

}



