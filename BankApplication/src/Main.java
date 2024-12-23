public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();


        StandardAccount standard = new StandardAccount(1, -100);
        BasicAccount basic = new BasicAccount(2, 100);
        PremiumAccount premium = new PremiumAccount(3);


        bank.openAccount(standard);
        bank.openAccount(basic);
        bank.openAccount(premium);


        standard.deposit(500);
        basic.deposit(200);
        premium.deposit(1000);


        System.out.println("Standard Account balance after withdrawing 600: " + standard.withdraw(600));
        System.out.println("Basic Account balance after withdrawing 150: " + basic.withdraw(150));
        System.out.println("Premium Account balance after withdrawing 500: " + premium.withdraw(500));


        System.out.println("All Accounts:");
        for (IAccount account : bank.getAllAccounts()) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }


        System.out.println("Accounts in Debt:");
        for (IAccount account : bank.getAllAccountsInDebt()) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }


        System.out.println("Accounts with Balance > 300:");
        for (IAccount account : bank.getAllAccountsWithBalance(300)) {
            System.out.println("Account " + account.getAccountNumber() + ": Balance = " + account.getCurrentBalance());
        }


        System.out.println("Closing accounts:");
        bank.closeAccount(1);
        bank.closeAccount(3);
    }
}
