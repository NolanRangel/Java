/* 

Overloading a method is just defining new method signatures for the same method name.

Remember that the method overloading technique is not only for constructors; any method can be overloaded.

Member variables are typically declared inside the class before any method and are accessed via getter and setter methods. The variables themselves should almost always be declared as private to prevent direct access to the field from other parts of the application, so you can control how they should be used in a uniform way. Getters are methods that retrieve a field value and setters are methods that set the field value. 

Always write getters and setters for private member variables

*/
import java.util.ArrayList; 


public class Item{
    private String name;
    private double price;
    private int index;

    // constructor as empty list
    public Item(){}
    // constructor
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getIndex(){
        return this.index;
    }



    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setIndex(int index){
        this.index = index;
    }


}
