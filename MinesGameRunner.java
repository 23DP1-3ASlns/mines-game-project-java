import java.util.Scanner;

public class MinesGameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(1000); // Start balance

        System.out.println("Welcome to Mines Game! Your balance: $" + player.getBalance());
        System.out.print("Enter grid size (e.g. 5 for 5x5): ");
        int size = scanner.nextInt();
        System.out.print("Enter number of mines: ");
        int mines = scanner.nextInt();
        System.out.print("Enter bet amount: ");
        double bet = scanner.nextDouble();

        MinesGame game = new MinesGame(player, size, mines, bet);
        game.startGame();
    }
}
