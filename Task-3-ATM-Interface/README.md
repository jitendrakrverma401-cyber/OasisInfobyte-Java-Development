# OASIS Infobyte Java Development Internship – Task 3

## ATM Interface

A console-based ATM Interface developed in Java as part of the **OASIS Infobyte Java Development Internship**.

The project demonstrates core Java programming, object-oriented programming, account management, authentication, banking operations, transaction handling, input validation, and basic security through PIN authentication.

---

## 📌 Project Objective

The objective of this project is to develop a functional **ATM Interface** that allows a user to authenticate using an account number and PIN and perform common banking operations through a console-based menu.

The application includes account authentication, balance inquiry, deposits, withdrawals, transfers, transaction history, PIN changing, and account locking after multiple incorrect PIN attempts.

---

## ✨ Features

### 1. Account Authentication
- Accepts a 4-digit account number.
- Verifies whether the account exists.
- Requests a 4-digit PIN.
- Allows a maximum of **3 incorrect PIN attempts**.
- Locks the account after three unsuccessful attempts.
- Prevents access to a locked account.

### 2. Account Summary
After successful authentication, the application displays:
- Account holder name
- Account number
- Current balance

### 3. Check Balance
The user can view the current account balance.

### 4. Deposit
- Accepts a deposit amount.
- Rejects invalid or non-positive amounts.
- Updates the account balance.
- Records successful deposits in transaction history.

### 5. Withdrawal
- Accepts a withdrawal amount.
- Checks the available balance.
- Prevents withdrawal when the amount exceeds the balance.
- Records successful withdrawals in transaction history.

### 6. Transfer
The application supports transferring money from one account to another.

Transfer validation includes:
- Sender account verification
- Receiver account verification
- Prevention of transfers to the same account
- Prevention of zero or negative transfers
- Insufficient-balance checking
- Balance update for the sender and receiver
- Recording the transfer in transaction history

### 7. Transaction History
The application maintains transactions using an `ArrayList<Transaction>` and displays:
- Transaction type
- Account number
- Transaction amount

Supported transaction records include:
- Deposit
- Withdrawal
- Transfer

### 8. Change PIN
An authenticated user can:
- Enter the current PIN.
- Enter a new PIN.
- Set a new 4-digit PIN.

### 9. Input Validation
The application validates:
- Account number format
- PIN format
- Menu choices
- Deposit amounts
- Withdrawal amounts
- Transfer amounts
- Invalid account numbers
- Insufficient balance

### 10. Exit
The user can safely exit the ATM application through the menu.

---

## 🛠️ Technologies Used

- **Programming Language:** Java
- **Data Structures:** `ArrayList`
- **Input Handling:** `Scanner`
- **Development Environment:** Visual Studio Code
- **Application Type:** Console-based application

---

## 📂 Project Structure

```text
ATM-Interface/
│
├── Main.java
├── ATM.java
├── Account.java
├── Bank.java
├── Transaction.java
└── README.md
```

---

## 📄 Class Description

### `Main.java`

The main entry point of the application.

Responsibilities:
- Creates the bank and ATM objects.
- Creates demonstration accounts.
- Handles account-number and PIN authentication.
- Displays the account summary.
- Displays the ATM menu.
- Accepts user input.
- Calls ATM operations based on the selected menu option.

### `ATM.java`

Contains the main ATM banking operations.

Responsibilities:
- Withdraw money
- Deposit money
- Check balance
- Transfer money
- Maintain transaction history

The class uses:

```java
ArrayList<Transaction>
```

to store transaction records.

### `Account.java`

Represents an individual bank account.

Stores:
- Account number
- Account holder name
- Balance
- PIN
- Account lock status

Responsibilities:
- Deposit
- Withdrawal
- PIN verification
- PIN changing
- Account locking
- Account information retrieval

### `Bank.java`

Manages the accounts used by the application.

Responsibilities:
- Store accounts in an `ArrayList<Account>`
- Create accounts
- Find accounts using account numbers

### `Transaction.java`

Represents an individual transaction.

Stores:
- Account number
- Transaction type
- Transaction amount

It provides getter methods to retrieve transaction information.

---

## 🧠 OOP Concepts Demonstrated

### Encapsulation

Class fields are declared `private` and accessed through methods such as:

```java
getAccountNumber()
getAccountHolderName()
getBalance()
```

### Abstraction

Banking operations are organized into appropriate classes such as `ATM`, `Account`, `Bank`, and `Transaction`, hiding implementation details from the main program.

### Object-Oriented Design

The application creates and works with objects such as:

```java
Bank bank = new Bank();
ATM atm = new ATM(bank);
Account account = new Account(...);
Transaction transaction = new Transaction(...);
```

### Composition / Object Relationships

The `Bank` manages multiple `Account` objects, while the `ATM` works with the `Bank` and maintains transaction records.

---

## 🔐 Authentication Flow

The application follows this basic authentication process:

```text
Start
  ↓
Create Accounts
  ↓
Enter Account Number
  ↓
Validate Account Number
  ↓
Find Account
  ↓
Check Account Lock
  ↓
Enter PIN
  ↓
Verify PIN
  ↓
Correct? ── No ──> Attempts Remaining
  │                    ↓
  │                 3 Attempts?
  │                    ↓ Yes
  │                 Lock Account
  │
  Yes
  ↓
Display Account Summary
  ↓
Open ATM Menu
```

---

## 🏧 ATM Menu

The current application provides the following menu:

```text
========== ATM ==========
1. Check Balance
2. Deposit
3. Withdraw
4. Transaction History
5. Transfer
6. Change PIN
7. Exit
Enter your choice:
```

---

## 👤 Demonstration Accounts

The current demonstration version initializes two accounts when the program starts.

| Account Number | Account Holder | Initial Balance |
|---|---|---:|
| 1001 | Jitendra Kumar | ₹10,000 |
| 1002 | Rahul Kumar | ₹15,000 |

The PINs are configured in `Main.java` for demonstration purposes.

> **Note:** These are sample accounts for the internship project. This console application does not use a database or permanent data storage, so account data is recreated when the application starts.

---

## ▶️ How to Run

### Prerequisites

Install the Java Development Kit (JDK) on your computer.

You can verify the installation using:

```bash
java -version
```

and:

```bash
javac -version
```

### Run using an IDE

1. Open the project folder in Visual Studio Code or another Java IDE.
2. Make sure all five `.java` files are in the same project folder.
3. Open `Main.java`.
4. Run the program.

### Run using Command Prompt / Terminal

Navigate to the project folder and compile:

```bash
javac *.java
```

Then run:

```bash
java Main
```

---

## 🧪 Testing Performed

The following functionality has been tested during development:

| Test | Result |
|---|---|
| Correct account number and PIN | ✅ Passed |
| Invalid account number | ✅ Passed |
| Incorrect PIN | ✅ Passed |
| Three incorrect PIN attempts | ✅ Passed |
| Account locking | ✅ Passed |
| Check balance | ✅ Passed |
| Deposit | ✅ Passed |
| Withdrawal | ✅ Passed |
| Insufficient balance | ✅ Passed |
| Transfer between accounts | ✅ Passed |
| Invalid transfer amount | ✅ Passed |
| Transfer to same account | ✅ Passed |
| Receiver account validation | ✅ Passed |
| Transaction history | ✅ Passed |
| Change PIN | ✅ Passed |
| Invalid menu input | ✅ Passed |
| Exit option | ✅ Passed |

---

## 💡 Example Transfer

Suppose account `1001` has:

```text
Balance: ₹10,000
```

The user selects:

```text
5. Transfer
```

and enters:

```text
Receiver Account: 1002
Transfer Amount: ₹2,000
```

The application verifies the accounts and available balance, then processes the transfer.

Expected result:

```text
Transfer successful.
Transferred ₹2000.0 to account 1002
```

---

## ⚠️ Current Project Limitations

This is a console-based internship project intended to demonstrate Java development concepts.

Current limitations include:

- Account data is stored in memory.
- No database is connected.
- Account information is recreated when the program starts.
- Transactions are not permanently stored after the program closes.
- PINs are demonstration values and are not encrypted.
- The application is not connected to a real banking system.

---

## 🚀 Future Enhancements

Possible improvements include:

- Database integration using MySQL or another database.
- Persistent account and transaction storage.
- Password/PIN encryption or secure hashing.
- GUI using JavaFX or Swing.
- Receipt generation.
- More detailed transaction records with date and time.
- Admin account management.
- Multiple ATM users.
- Improved exception handling.
- File-based transaction persistence.

---

## 🎓 Internship Information

**Organization:** OASIS Infobyte  
**Internship:** Java Development Internship  
**Task:** Task 3 – ATM Interface  
**Technology:** Java

This project was developed as part of the Java Development internship task requirements.

---

## 👨‍💻 Developer

**Jitendra Kumar**

Java Development Internship Project  
OASIS Infobyte

---

## 📌 Conclusion

The ATM Interface successfully demonstrates the implementation of a console-based banking application using Java and object-oriented programming principles.

The project provides authentication, account management, banking operations, transfer functionality, transaction history, PIN management, input validation, and account security through failed-login protection.
