import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts_;

    public Bank() {
        this.accounts_ = new ArrayList<Account>();
    }

    public void addCreditAccount(double balance, double maxDebt) {
        this.accounts_.add(new CreditAccount(balance, maxDebt));
    }

    public void addDebitAccount(double balance) {
        this.accounts_.add(new DebitAccount(balance));
    }

    private Account findAccount(int accountId) {
        for (Account account : this.accounts_) {
            if (account.getId() == accountId) {
                return account;
            }
        }

        return null;
    }

    public boolean checkTransactionValidity(int accountId, double amount) {
        // Search for the corresponding account
        Account account = findAccount(accountId);

        if (account == null) {
            System.out.println("Account with id " + accountId + " not found. End transaction.");
            return false;
        }
        else {
            return account.checkTransactionValidity(amount);
        }
    }

    public void performTransaction(int accountId, double amount) {
        Account account = findAccount(accountId);

        if (account == null) {
            System.out.println("Account with id " + accountId + " not found. Can't perform transaction.");
        }
        else {
            account.takeMoney(amount);
        }
    }
}
