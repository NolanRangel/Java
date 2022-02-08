import java.util.ArrayList;
import java.util.Random;


public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAccountValue;
    private static String accountNumber;
    

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.totalAccountValue = 0;
        this.accountNumber = accountId();
        numberOfAccounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance, double totalAccountValue) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalAccountValue = totalAccountValue;
        this.accountNumber =  accountId();
        numberOfAccounts++;
    }


    // getters
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    // static getter
    //  do not need this because it refers to the whole class
    // make sure to put in static
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    public void viewAccounts() {
        System.out.println("Checking Balance: " + checkingBalance + "\nSavings Balance: " + savingsBalance);
    }
    public String viewAccountNumber() {
        return this.accountNumber;
    }
    // deposit
    public void depositChecking(double depositChecking) {
            checkingBalance += depositChecking;
            totalAccountValue += depositChecking;
    }
    public void depositSavings(double depositSavings){
            savingsBalance += depositSavings;
            totalAccountValue += depositSavings;
    }
    // withdraw
    public void withdrawChecking(double withdrawChecking) {
        if(checkingBalance >= withdrawChecking){
            checkingBalance -= withdrawChecking;
        }
        else{
            System.out.println("Insufficient funds");
        }
    }
    public void withdrawSavings(double withdrawSavings) {
        if(savingsBalance >= withdrawSavings){
            savingsBalance -= withdrawSavings;
        }
        else{
            System.out.println("Insufficient funds");
        }

    }
    private String accountId() {
        String accNum = new String();

        Random rand = new Random();

        for(int i = 0; i < 10; i++) {
            accNum += (rand.nextInt(9));
        }
        return accNum;
    }

    

    


    
}