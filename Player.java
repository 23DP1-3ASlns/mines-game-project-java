public class Player {
    private double balance;

    public Player(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount;
    }

    public void addWinnings(double amount) {
        balance += amount;
    }
}
