
public class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;
    private boolean locked;
    
    public Account(String accountNumber, String accountHolderName,double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
        
    }

    public void deposit(double amount){
        if (amount > 0){
            balance = balance + amount;
            System.out.println("Deposit successful: ₹" + amount);
        }else{
            System.out.println("Invalid deposit amount.");

        }

    }

    public void withdraw(double amount){
        if (amount >  0 && amount <= balance){
            balance = balance - amount;
            System.out.println("Withdraw successful: ₹" + amount);
        }else{
            System.out.println("Invalid amount or insufficient balance.");

        }


    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }  

    public double getBalance() {
        return balance;
    
    }
    public boolean verifyPin(String enteredPin) {
    return pin.equals(enteredPin);
}

public void changePin(String newPin){
    this.pin = newPin;
}

public boolean isLocked() {
    return locked;
}

public void setLocked(boolean locked) {
    this.locked = locked;
}

}



        

    
    


    
