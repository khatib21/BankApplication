 public class PremiumAccount implements IAccount {
         private int accountNumber;
         private double balance;

         public PremiumAccount(int accountNumber) {
             this.accountNumber = accountNumber;
             this.balance = 0;
         }

         @Override
         public void deposit(double amount) {
             balance += amount;
         }

         @Override
         public double withdraw(double amount) {
             balance -= amount;
             return amount;
         }

         @Override
         public double getCurrentBalance() {
             return balance;
         }

         @Override
         public int getAccountNumber() {
             return accountNumber;
         }
     }


