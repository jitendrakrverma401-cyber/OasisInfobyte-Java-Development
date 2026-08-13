  
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        
        Bank bank = new Bank();
        ATM atm = new ATM(bank);

        bank.createAccount("1001","Jitendra Kumar",10000,"1234");
        bank.createAccount("1002", "Rahul kumar", 15000,"5678");

        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();

        if (!accountNumber.matches("\\d{4}")){
            System.out.println("Invalid account number. Please enter a 4 -digit account number.");
            scanner.close();
            return;
        }

        Account account = bank.findAccount(accountNumber);

        if (account == null) {
           System.out.println("Account not found.");
           scanner.close();
           return;
       }
       
       if (account.isLocked()){
           System.out.println("Account is locked. Please contact the bank.");
           scanner.close();
           return;
       }

       int attempts = 0;
       boolean authenticated = false;

 while (attempts <3) {

       System.out.print("Enter PIN: ");
       String enteredPin = scanner.nextLine();

       if (account.verifyPin(enteredPin)) {
           authenticated = true;
           break;
       }

       attempts++;
       System.out.println("Incorrect PIN. Attempts remaining: " + (3 - attempts));
 }
 
  if (!authenticated){
    account.setLocked(true);
    System.out.println("Too many incorrect attempts. Account is now  locked.");
    scanner.close();
    return;
  }

        System.out.println("Welcome, " + account.getAccountHolderName() + "!");
        System.out.println("================================");
        System.out.println("        ACCOUNT SUMMARY");
        System.out.println("================================");
        System.out.println("Account Holder : " + account.getAccountHolderName());
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Balance        : ₹" + account.getBalance());
        System.out.println("================================");



        int choice;

        do{
            System.out.println("\n========== ATM ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Transfer");
            System.out.println("6. Change PIN");
            System.out.println("7. Exit");
            System.out.println("Enter your choice:");

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a number from 1 to 7.");
            scanner.next();
            choice =-1;
        }
            switch (choice) {
    case 1:
         System.out.println("Current balance: ₹" + atm.checkBalance(accountNumber));
         break;
        

    case 2:
        System.out.print("Enter deposit amount: ");

        if(scanner.hasNextDouble()){
            double depositAmount = scanner.nextDouble();
            atm.deposit(accountNumber,depositAmount);
        } else {
            System.out.println("Invalid amount. Please enter a number.");
            scanner.next();
        }
        break;

    case 3:
        System.out.print("Enter withdrawal amount: ");

        if(scanner.hasNextDouble()){
            double withdrawalAmount = scanner.nextDouble();
            atm.withdraw(accountNumber, withdrawalAmount);
        }else {
            System.out.println("Invalid amount. please enter a number.");
            scanner.next();
        }
        break;

    case 4:
        System.out.println("\nTransaction History:");

        for (Transaction transaction : atm.getTransactions()) {
            System.out.println(
                transaction.getType() + " | Account: "
                + transaction.getAccountNumber()
                + " | Amount: ₹" + transaction.getAmount()
            );
        }
        break;

    case 5:
        System.out.print("Enter receiver account number: ");
    String receiverAccountNumber = scanner.next();

    if (!receiverAccountNumber.matches("\\d{4}")) {
        System.out.println("Invalid receiver account number.");
        break;
    }

    System.out.print("Enter transfer amount: ");

    if (scanner.hasNextDouble()) {
        double transferAmount = scanner.nextDouble();
        atm.transfer(accountNumber, receiverAccountNumber, transferAmount);
    } else {
        System.out.println("Invalid amount. Please enter a number.");
        scanner.next();
    }
    break;
 
    default:
        if (choice != -7){
  }

    case 6:
        System.out.println("Enter current PIN");
    String currentPin = scanner.next();

    if (account.verifyPin(currentPin)) {

        System.out.print("Enter new PIN: ");
        String newPin = scanner.next();

        if (newPin.matches("\\d{4}")) {
            account.changePin(newPin);
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
        }

    } else {
        System.out.println("Incorrect current PIN.");
    }
    break;
    case 7:
        System.out.println("Thank you for using the ATM.");
        break;
}

    } while (choice !=7);

      scanner.close();
        }
    }


    


    






    

