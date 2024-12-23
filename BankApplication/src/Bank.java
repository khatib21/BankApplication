import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;


    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount accountToRemove = null;
        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                if (account.getCurrentBalance() < 0) {

                    System.out.println("Account cannot be closed due to debt.");
                    return;
                }
                accountToRemove = account;
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {

        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {

        List<IAccount> inDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                inDebt.add(account);
            }
        }
        return inDebt;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balance) {

        List<IAccount> withBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balance) {
                withBalance.add(account);
            }
        }
        return withBalance;
    }
}


