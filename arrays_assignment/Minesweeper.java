public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mineCell = new boolean[m + 2][n + 2];
        int[][] board = new int[m + 2][n + 2];
        int counter = k;
        if ((m * n) < k) {
            System.out.println("There cannot be more mines than cells.");
        } else if ((m * n) == k) {
            for (int i = 1; i < mineCell.length - 1; i++) {
                for (int j = 1; j < mineCell[i].length - 1; j++) {
                    mineCell[i][j] = true;
                }
            }
        } else if (m == 1 || n == 1) {
            while (counter > 0) {
                int ri = 1;
                int rj = 1;
                if (m == 1) {
                    rj = (int) (Math.random() * n + 1);
                } else {
                    ri = (int) (Math.random() * m + 1);
                }
                if (ri != 0 && ri != m - 1 && rj != 0 && rj != n - 1 && !mineCell[ri][rj]) {
                    mineCell[ri][rj] = true;
                    counter--;
                }
            }
        } else {
            while (counter > 0) {
                int ri = (int) (Math.random() * m + 1);
                int rj = (int) (Math.random() * n + 1);
                if (ri != 0 && rj != 0 && !mineCell[ri][rj]) {
                    mineCell[ri][rj] = true;
                    counter--;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int boardCounter = 0;
                if (mineCell[i - 1][j - 1]) {
                    boardCounter++;
                }
                if (mineCell[i - 1][j]) {
                    boardCounter++;
                }
                if (mineCell[i - 1][j + 1]) {
                    boardCounter++;
                }
                if (mineCell[i][j + 1]) {
                    boardCounter++;
                }
                if (mineCell[i + 1][j + 1]) {
                    boardCounter++;
                }
                if (mineCell[i + 1][j]) {
                    boardCounter++;
                }
                if (mineCell[i + 1][j - 1]) {
                    boardCounter++;
                }
                if (mineCell[i][j - 1]) {
                    boardCounter++;
                }
                if (!mineCell[i][j])
                    board[i][j] = boardCounter;
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if ((m * n) < k) {
                    break;
                }
                if (mineCell[i][j]) {
                    System.out.print("*  ");
                } else {
                    System.out.print(board[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
