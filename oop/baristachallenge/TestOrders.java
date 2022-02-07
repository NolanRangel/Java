import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

        Orders order1 = new Orders();

        Orders order2 = new Orders();

        Orders order3 = new Orders("Nolan");
        Orders order4 = new Orders("Cal");
        Orders order5 = new Orders("Mikayla");

        Item item1 = new Item("latte",2.00);

        Item item2 = new Item("coffee", 1.00);

        Item item3 = new Item("cappuccino", 3.00);

        Item item4 = new Item("mocha", 4.00);

        Item item5 = new Item("espresso", 2.50);

        order1.addItem(item2);
        order1.addItem(item5);

        order2.addItem(item3);
        order2.addItem(item2);

        order3.addItem(item2);
        order3.addItem(item2);

        order4.addItem(item4);
        order4.addItem(item3);

        order5.addItem(item5);
        order5.addItem(item1);

        System.out.println(order3.getStatusMessage());

        order2.setReady(true);
        order5.setReady(true);

        System.out.println(order2.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        System.out.println(order5.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

    

        

    }
}

