public class BasicAccount implements IAccount {
        private int accountNumber;
        private double balance;
        private double withdrawalLimit;

        public BasicAccount(int accountNumber, double withdrawalLimit) {
            this.accountNumber = accountNumber;
            this.withdrawalLimit = Math.max(0, withdrawalLimit); // Enforce positive limit
            this.balance = 0;
        }

        @Override
        public void deposit(double amount) {
            balance += amount;
        }

        @Override
        public double withdraw(double amount) {
            double maxWithdraw = Math.min(balance, withdrawalLimit);
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


