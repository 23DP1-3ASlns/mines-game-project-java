import java.util.Random;

public class Grid {
    private final boolean[][] mines;
    private final int size;
    private final Random random = new Random();

    public Grid(int size, int mineCount) {
        this.size = size;
        this.mines = new boolean[size][size];
        placeMines(mineCount);
    }

    private void placeMines(int mineCount) {
        int placed = 0;
        while (placed < mineCount) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if (!mines[x][y]) {
                mines[x][y] = true;
                placed++;
            }
        }
    }

    public boolean isMine(int x, int y) {
        return mines[x][y];
    }
}
