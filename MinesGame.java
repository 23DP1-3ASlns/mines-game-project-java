import java.util.Scanner;

public class MinesGame {
    private final Player player;
    private final Grid grid;
    private final Scanner scanner;
    private double bet;
    private double multiplier;

    public MinesGame(Player player, int gridSize, int mineCount, double betAmount) {
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.grid = new Grid(gridSize, mineCount);
        this.bet = betAmount;
        this.multiplier = 1.0;
    }

    public void startGame() {
        player.placeBet(bet);
        System.out.println("Game started! Bet placed: $" + bet);
        
        while (true) {
            System.out.print("Enter cell (row col): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if (grid.isMine(x, y)) {
                System.out.println("Boom! You hit a mine. You lost your bet.");
                break;
            } else {
                multiplier += 0.5;
                System.out.println("Safe! Current multiplier: " + multiplier + "x");
                System.out.print("Cash out? (y/n): ");
                if (scanner.next().equalsIgnoreCase("y")) {
                    double winnings = bet * multiplier;
                    player.addWinnings(winnings);
                    System.out.println("You cashed out: $" + winnings);
                    break;
                }
            }
        }
        System.out.println("Game over. Final balance: $" + player.getBalance());
    }
}
