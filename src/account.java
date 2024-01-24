public class account {
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        public account(String accountNumber, String accountHolderName, double balance) {
                this.accountNumber = accountNumber;
                this.accountHolderName = accountHolderName;
                this.balance = balance;
        }

        public String getAccountHolderName() {
                return accountHolderName;
        }

        public void setAccountHolderName(String accountHolderName) {
                this.accountHolderName = accountHolderName;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }
}
