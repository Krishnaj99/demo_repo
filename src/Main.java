import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String password; // Encrypted password
    public Customer(String customerId, String name, String email, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = encryptPassword(password);
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        // Implement email validation logic if needed
        this.email = email;
    }
    public void changePassword(String currentPassword, String newPassword) {
        // Implement password change logic, including validation
        if (authenticate(currentPassword)) {
            this.password = encryptPassword(newPassword);
        } else {
            // Handle incorrect current password
        }
    }
    private boolean authenticate(String passwordAttempt) {
        return decryptPassword().equals(passwordAttempt);
    }
    private String encryptPassword(String password) {
        return password;
    }
    private String decryptPassword() {
        return password;
    }
}
public class Account {
    private String accountId;
    private double balance;
    private List<Transaction> transactionHistory;

    // Constructor
    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    // Getter for account balance (Read-only access)
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds
    public void deposit(double amount) {
        // Implement deposit logic, including validation
        balance += amount;
        transactionHistory.add(new Transaction(amount, "Deposit"));
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        // Implement withdrawal logic, including validation
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(amount, "Withdrawal"));
        } else {
            // Handle insufficient funds
        }
    }

    // Getter for transaction history (Read-only access)
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

// Transaction class to encapsulate transaction data
public class Transaction {
    private double amount;
    private String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

// Main class for testing
public class OnlineBankingSystem {
    public static void main(String[] args) {
        // Create a customer and an account
        Customer customer = new Customer("C123", "John Doe", "john@example.com", "password123");
        Account account = new Account("A456", 1000.0);

        // Deposit and withdraw funds
        account.deposit(500.0);
        account.withdraw(200.0);

        // Access account balance and transaction history
        System.out.println("Account Balance: $" + account.getBalance());
        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println("Type: " + transaction.getType() + ", Amount: $" + transaction.getAmount());
        }

        // Change customer email
        customer.setEmail("newemail@example.com");

        // Change customer password
        customer.changePassword("password123", "newPassword456");
    }
}
