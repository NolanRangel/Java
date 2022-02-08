import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Orders> orders = new ArrayList<Orders>();

    public CoffeeKiosk(){

    }

    public ArrayList<Item> getMenu(){
        return menu;
    }
    public ArrayList<Orders> getOrders(){
        return orders;
    }

    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        menu.add(item);
        int index = menu.indexOf(item);
        item.setIndex(index);
        
    }

    public void addOrder(Orders orders){
        this.orders.add(orders);
    }

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
        
        // menu = addOrder(name);
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
            int i = Integer.parseInt(itemNumber);
            // System.out.println(i);
            if(i < this.menu.size()) {
                Item newOrder = menu.get(i);
                order.addItem(newOrder);
            } else{
                System.out.println("Out of stock");
            }

            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        order.display();
        this.orders.add(order);
    }


}