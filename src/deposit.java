abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();
}

interface Transaction {
    void makeTransaction(Account sourceAccount, Account destinationAccount, double amount, String transactionType);
}

interface LoanApplication {
    boolean applyForLoan(Customer customer, double loanAmount);
    void processLoanApplication(Customer customer, double loanAmount);
}

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            super.balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + super.balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be greater than zero.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (super.balance >= amount) {
                super.balance -= amount;
                System.out.println("Withdrew $" + amount + ". New balance: $" + super.balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be greater than zero.");
        }
    }

    @Override
    public double getBalance() {
        return super.balance;
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            super.balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + super.balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be greater than zero.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (super.balance >= amount) {
                super.balance -= amount;
                System.out.println("Withdrew $" + amount + ". New balance: $" + super.balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be greater than zero.");
        }
    }

    @Override
    public double getBalance() {
        return super.balance;
    }
}

class TransactionImpl implements Transaction {
    @Override
    public void makeTransaction(Account sourceAccount, Account destinationAccount, double amount, String transactionType) {
        if (sourceAccount != null && destinationAccount != null && amount > 0) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
                System.out.println("Transaction successful.");
            } else {
                System.out.println("Transaction failed. Insufficient balance.");
            }
        } else {
            System.out.println("Invalid transaction details.");
        }
    }
}

class LoanImpl implements LoanApplication {
    @Override
    public boolean applyForLoan(Customer customer, double loanAmount) {
        if (customer != null && loanAmount > 0) {
            // Implement loan application logic (e.g., credit check)
            return true; // For simplicity, always approve the loan
        } else {
            return false;
        }
    }

    @Override
    public void processLoanApplication(Customer customer, double loanAmount) {
        if (applyForLoan(customer, loanAmount)) {
            System.out.println("Loan application approved and processed.");
        } else {
            System.out.println("Loan application rejected.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "555-123-4567");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com", "555-987-6543");

        // Create accounts for customers
        Account savingsAccount = new SavingsAccount("SAV123", 1000.0);
        Account checkingAccount = new CheckingAccount("CHK456", 500.0);

        // Create a transaction manager
        Transaction transactionManager = new TransactionImpl();

        // Perform transactions
        transactionManager.makeTransaction(savingsAccount, checkingAccount, 200.0, "Transfer;
    }
}
