import java.util.ArrayList;

public class CoffeeKiosk {
    // instantiating instances of classes
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Orders> orders = new ArrayList<Orders>();

    // constructor initialized to empty array
    public CoffeeKiosk(){
    }

    // getters
    public ArrayList<Item> getMenu(){
        return menu;
    }
    public ArrayList<Orders> getOrders(){
        return orders;
    }
    // add a menu item to class Item
    // takes in a String and double, does not return
    // adds an item to the menu in the Item class
    // indexOf takes in an object and turns out an int? and gets added by setIndex
    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        // System.out.println(item);

        menu.add(item);
        int index = menu.indexOf(item);
        item.setIndex(index);
        
    }

    // display the menu to user
    //  menu is the Item class list
    public void displayMenu() {
        for(Item i : this.menu) {
            System.out.println(i.getIndex() + " " + i.getName() + " -- " + i.getPrice());
        }
    }

    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Orders order = new Orders(name);
        displayMenu();
        

    	// Prompts the user to enter an item number 0-5
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // while loop that executes until q is entered
        while(!itemNumber.equals("q")) {
            /* itemNumber comes in as a string so it must be converted to an int.
                the parseInt method parses a value as a string and returns the first integer. */
            // unsure of Integer
            int i = Integer.parseInt(itemNumber);
            // System.out.println(i);
            if(i < this.menu.size()) {
                Item newOrder = menu.get(i);
                order.addItem(newOrder);
            } else{
                System.out.println("Out of stock");
            }
            //  call readLine in while loop so the user can keep inputting
            itemNumber = System.console().readLine();
        }
        // once while loop is completed display users final order
        // and add the final order with User name, item name(s), total price
        order.display();
        this.orders.add(order);
    }


}