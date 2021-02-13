/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class FunctionGraph {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            x[i] = Math.PI * i / n;
        }
        for (int i = 0; i <= n; i++) {
            y[i] = Math.sin(4 * x[i]) + Math.sin(20 * x[i]);
        }
        // changed x and y scales from:
        // (0, Math.Pi)
        // (-2.0, 2.0)
        // to get appropriate padding in Standard Draw window
        StdDraw.setXscale(-0.5, Math.PI + 0.5);
        StdDraw.setYscale(-2.5, 2.5);
        for (int i = 1; i <= n; i++) {
            StdDraw.line(x[i - 1], y[i - 1], x[i], y[i]);
        }

    }
}
