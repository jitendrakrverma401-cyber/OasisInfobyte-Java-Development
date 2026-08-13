
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

   public void createAccount(String accountNumber, String accountHolderName, double initialBalance, String pin) {
    Account account = new Account(accountNumber, accountHolderName, initialBalance, pin);
    accounts.add(account);

    System.out.println("Account created successfully.");
}

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}