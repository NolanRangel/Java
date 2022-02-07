import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Items items1 = new Items();
        items1.name = "mocha";
        items1.price = 11.50;

        Items items2 = new Items();
        items2.name = "latte";
        items2.price = 21.50;

        Items items3 = new Items();
        items3.name = "drip coffe";
        items3.price = 12.50;

        Items items4 = new Items();
        items4.name = "cappuccino";
        items4.price = 15.50;
    
        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        order1.name = "Nolan";
        order1.total = 33.50;
        order1.ready = false;

        Orders order2 = new Orders();
        order2.name = "Cal";
        order2.total = 3.50;
        order2.ready = false;


        Orders order3 = new Orders();
        order3.name = "Mikayla";
        order3.total = 23.50;
        order3.ready = false;

        Orders order4 = new Orders();
        order4.name = "Julie";
        order4.total = 23.50;
        order4.ready = false;


        order2.items.add(items1);
        order2.total += items1.price;

        order3.items.add(items4);
        order3.total += items4.price;

        order4.items.add(items2);
        order4.total += items2.price;

        order1.ready = true;

        order4.items.add(items2);
        order4.items.add(items2);
        order4.total += items2.price * 2; 

        order2.ready = true;
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.println(order1);
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        // System.out.printf("Ready: %s\n", order2.items.get(0));


        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);


        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);


        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
