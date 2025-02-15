# **ATM Simulator**

## **Overview**
The **ATM Simulator** is a Java-based project that simulates basic banking operations such as account creation, balance inquiry, deposits, withdrawals, and mini-statements. It provides a user-friendly interface with secure authentication.

## **Features**

### 1. Create New Account
- Users can create a new account by providing personal details.
- A unique account number and PIN are generated for security.

### 2. Balance Enquiry
- Users can check their current account balance.
- The balance is retrieved from the database in real-time.

### 3. Deposit Money
- Users can deposit money into their account.
- The deposited amount is updated in the account balance.

### 4. Withdraw Money
- Users can withdraw money from their account.
- Withdrawal requests are processed only if the balance is sufficient.

### 5. Mini Statement
- Users can view a mini statement of their recent transactions.
- The statement includes transaction date, type (deposit/withdrawal), and amount.

### 6. Secure Login & Signup
- Users can sign up for a new account with valid details.
- Secure login with PIN authentication is required to access account features.

## **Technologies Used**
- **Java** (Core Java, JDBC)
- **MySQL** (Database for storing user accounts and transactions)
- **Swing (Java AWT)** (Graphical User Interface)

## **Installation & Setup**
1. Clone the repository:
   ```sh
   git clone https://github.com/Gopavarapu-Harish/ATM_Simulator.git
   ```
2. Open the project in an IDE (Eclipse/IntelliJ IDEA).
3. Configure the database in `conn.java` with your MySQL credentials.
4. Run the `ATM.java` file to start the application.

## **Contributing**
Contributions are welcome! Feel free to fork the repository and submit a pull request.

## **License**
This project is licensed under the **MIT License**.



