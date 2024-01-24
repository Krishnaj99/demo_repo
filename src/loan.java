public class loan {
    private int loanID;
    private double customer;
    private double loanAmount;
    private double interestRate;
    private double balance;

    public loan(int loanID, double customer, double loanAmount, double interestRate, double balance) {
        this.loanID = loanID;
        this.customer = customer;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public double getCustomer() {
        return customer;
    }

    public void setCustomer(double customer) {
        this.customer = customer;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}