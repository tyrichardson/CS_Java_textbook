/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Ramanujan {

    public static boolean isRamanujan(long n) {
        boolean is = false;
        if (n < 3) return is;

        long a3 = 0;
        for (long a = 1; a <= (long) Math.cbrt(n); a++) {
            a3 = a * a * a;
            if (a3 > n) break;
        }

        long b = (long) Math.cbrt((n - a3));
        long b3 = b * b * b;
/*
        StdOut.println("cube root of n = " + (long) Math.cbrt(n));
        StdOut.println("a3 = " + a3);
        StdOut.println("b3 = " + b3);
        StdOut.println("total = " + (a3 + b3));
        StdOut.println("n = " + n);
*/

        if ((a3 + b3) == n) is = true;

        return is;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
