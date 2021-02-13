public class selfAvoidingWalk {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int deadEnds = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEnds++;
                    break;
                }
                double r = Math.random();
                if (r < 0.25) {
                    if (!a[x + 1][y])
                        x++;
                } else if (r < 0.50) {
                    if (!a[x - 1][y])
                        x--;
                } else if (r < 0.75) {
                    if (!a[x][y + 1])
                        y++;
                } else if (r < 1.00) {
                    if (!a[x][y - 1])
                        y--;
                }
            }
        }
        System.out.println(100 * deadEnds / trials + "% dead ends");
    }
}
