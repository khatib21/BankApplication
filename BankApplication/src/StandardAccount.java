public class StandardAccount implements IAccount {
        private int accountNumber;
        private double balance;
        private double creditLimit;

        public StandardAccount(int accountNumber, double creditLimit) {
            this.accountNumber = accountNumber;
            this.creditLimit = creditLimit < 0 ? creditLimit : 0; // Enforce negative limit
            this.balance = 0;
        }

        @Override
        public void deposit(double amount) {
            balance += amount;
        }

        @Override
        public double withdraw(double amount) {
            double maxWithdraw = balance - creditLimit;
            double withdrawn = Math.min(amount, maxWithdraw);
            balance -= withdrawn;
            return withdrawn;
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



