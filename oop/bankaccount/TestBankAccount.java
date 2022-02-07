

public class TestBankAccount {
    public static void main(String[] args) {


        BankAccount account1 = new BankAccount(100.00, 100.00, 0);

        account1.depositChecking(10);
        account1.depositSavings(100);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        account1.withdrawSavings(200);
        System.out.println(account1.getSavingsBalance());
        account1.viewAccounts();
        System.out.println(account1.viewAccountNumber());
        
    }
}