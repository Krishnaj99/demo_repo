public class savings extends account {
    private final int monthly_limit;
    public savings(String accountNumber, String accountHolderName, double balance, int monthly_limit) {
        super(accountNumber, accountHolderName, balance);
        this.monthly_limit = monthly_limit;
    }
    public int getMonthly_limit() {
        return monthly_limit;
    }
}