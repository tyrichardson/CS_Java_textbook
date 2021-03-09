/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x < 0) {
            return 0.0;
        }
        else if (x == 0) {
            return 0.5;
        }
        else {
            return 1.0;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else {
            return 1 / (1 + Math.exp(-x));
        }
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else {
            return ((Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)));
        }
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else {
            return x / (1 + Math.abs(x));
        }
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x <= -2) {
            return -1.0;
        }
        else if (x > -2 && x < 0) {
            return x + (Math.pow(x, 2) / 4);
        }
        else if (x >= 0 && x < 2) {
            return x - (Math.pow(x, 2) / 4);
        }
        else {
            return 1.0;
        }
    }

    // Takes a double command-line argument x and prints each activation function.
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + n + ") = " + heaviside(n));
        StdOut.println("  sigmoid(" + n + ") = " + sigmoid(n));
        StdOut.println("     tanh(" + n + ") = " + tanh(n));
        StdOut.println(" softsign(" + n + ") = " + softsign(n));
        StdOut.println("     sqnl(" + n + ") = " + sqnl(n));
    }
}
