import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello %s, Lovely to see you", name);
    }
    public String guestGreeting(String name, String dayPeriod){
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }

    // or

    // public String dateAnnouncement() {
    //     return String.format("It is currently %s", new Date());
    // }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis") > -1){
            return "Right away, your majesty....";
        }
        else if(conversation.indexOf("Alfred") > -1){
            return "At your service!";
        }
        else {
        return "Right. And with that I shall retire";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

