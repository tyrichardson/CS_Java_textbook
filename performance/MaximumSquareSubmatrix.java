/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int[][] b = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            b[i][0] = a[i][0];
        }

        for (int j = 0; j < b.length; j++) {
            b[0][j] = a[0][j];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i][j] == 1) {
                    b[i][j] = Math.min(b[i][j - 1], Math.min(b[i - 1][j],
                                                             b[i - 1][j - 1])) + 1;
                }
                else {
                    b[i][j] = 0;
                }
            }
        }

        int max = b[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (max < b[i][j]) {
                    max = b[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        int subSize = size(a);
        StdOut.println(subSize);
    }
}
