import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {     
        CoffeeKiosk kiosk = new CoffeeKiosk();

        kiosk.addMenuItem("latte",2.00);
        kiosk.addMenuItem("coffee", 1.00);
        kiosk.addMenuItem("cappuccino", 3.00);
        kiosk.addMenuItem("mocha", 4.00);
        kiosk.addMenuItem("espresso", 2.50);

        kiosk.newOrder();
        

    }
}