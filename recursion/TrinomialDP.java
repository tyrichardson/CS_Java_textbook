/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TrinomialDP {

    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        long[][] arr = new long[n + 1][n + 1];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i - 1][j];
                if (j > 0)
                    arr[i][j] += arr[i - 1][j - 1];
                if (j < arr[i].length - 1)
                    arr[i][j] += arr[i - 1][j + 1];
                if (j == 0)
                    arr[i][j] += arr[i - 1][j + 1];
            }
        }
        return arr[n][Math.abs(k)];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
