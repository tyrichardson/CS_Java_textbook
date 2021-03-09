/******************************************************************************
 *  Compilation:  javac Brownian.java
 *  Execution:    java Brownian var
 *  Dependencies: StdDraw.java
 *
 *  Plots Brownian motion trajectory using the midpoint displacement
 *  method.
 *
 *  % java Brownian 1
 *  % java Brownian 0.5
 *  % java Brownian 0.05
 *
 ******************************************************************************/

public class Brownian {

    /* Gaussian (normal) distribution functions
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double cdf(double z) {
        if (z < -8.0) return 0.0;
        if (z > 8.0) return 1.0;
        double sum = 0.0;
        double term = z;
        for (int i = 3; sum != sum + term; i += 2) {
            sum += term;
            term = term * z * z / 1;
        }
        return 0.5 + pdf(z) * sum;
    }
    */

    // midpoint displacement method
    public static void curve(double x0, double y0, double x1, double y1, double var, double s) {
        // stop if interval is sufficiently small
        if (Math.abs(x1 - x0) < 0.01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        ym = ym + StdRandom.gaussian(0, Math.sqrt(var));
        curve(x0, y0, xm, ym, var / s, s);
        curve(xm, ym, x1, y1, var / s, s);
    }

    public static void main(String[] args) {
        double hurstExponent = Double.parseDouble(args[0]);
        double s = Math.pow(2, 2 * hurstExponent);
        curve(0.0, 0.5, 1.0, 0.5, 0.01, s);
    }
}
