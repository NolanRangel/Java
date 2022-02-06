public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready!";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double dripCoffee = 2.5;
        double latte = 4.75;
        double cappuccino = 4.25;
        double mochaPrice = 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = " Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        dripCoffee = 3.5;
        latte = 5.75;
        cappuccino = 5.25;
        mochaPrice = 4.5;

        isReadyOrder1 = true;
        isReadyOrder2 = false;
        isReadyOrder3 = false;
        isReadyOrder4 = false;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // Cindhuri order status
        System.out.println(customer1 + pendingMessage);
        // Noah check drick status
        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage + " " + displayTotalMessage + cappuccino);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }

        // Sams order check
        System.out.println(customer2 + displayTotalMessage + latte * 2);
        if(isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // Jimmy order change
        double difference = latte - dripCoffee;
        System.out.println(displayTotalMessage + difference);

    }
}
