import java.util.ArrayList;

public class ATM {

    private Bank bank;
    private ArrayList<Transaction> transactions;

    public ATM(Bank bank) {
        this.bank = bank;
        this.transactions = new ArrayList<>();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = bank.findAccount(accountNumber);

        if (account != null) {
            double oldBalance = account.getBalance();

            account.withdraw(amount);

            if (account.getBalance() < oldBalance) {
                Transaction transaction =
                        new Transaction(accountNumber, "WITHDRAW", amount);

                transactions.add(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

        public void deposit(String accountNumber, double amount) {
    Account account = bank.findAccount(accountNumber);

    if (account != null) {
        double oldBalance = account.getBalance();

        account.deposit(amount);

        if (account.getBalance() > oldBalance) {
            Transaction transaction =
                    new Transaction(accountNumber, "DEPOSIT", amount);

            transactions.add(transaction);
        }
    } else {
        System.out.println("Account not found.");

      }

 }

 public double checkBalance(String accountNumber) {
    Account account = bank.findAccount(accountNumber);

    if (account != null) {
        return account.getBalance();
    } else {
        System.out.println("Account not found.");
        return -1;
    }
}
public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {

    Account fromAccount = bank.findAccount(fromAccountNumber);
    Account toAccount = bank.findAccount(toAccountNumber);

    if (fromAccount == null) {
        System.out.println("Sender account not found.");
        return;
    }

    if (toAccount == null) {
        System.out.println("Receiver account not found.");
        return;
    }

    if (fromAccountNumber.equals(toAccountNumber)) {
        System.out.println("Cannot transfer money to the same account.");
        return;
    }

    if (amount <= 0) {
        System.out.println("Invalid transfer amount.");
        return;
    }

    if (fromAccount.getBalance() < amount) {
        System.out.println("Insufficient balance for transfer.");
        return;
    }

    fromAccount.withdraw(amount);
    toAccount.deposit(amount);

    Transaction transaction =
            new Transaction(fromAccountNumber, "TRANSFER TO " + toAccountNumber, amount);

    transactions.add(transaction);

    System.out.println("Transfer successful.");
    System.out.println("Transferred ₹" + amount + " to account " + toAccountNumber);
}

    public ArrayList<Transaction> getTransactions() {
    return transactions;

   }

}


    




    
    

