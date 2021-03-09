/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RevesPuzzle {

    private static void reves(int n, String from, String to, String temp, String dest) {
        int k = (int) Math.round(((n + 1) - (Math.sqrt(2 * n + 1))));
        if (k == 0) return;
        reves(k, from, to, temp, dest);
        StdOut.println("Move disc " + k + " from " + from + " to " + to);
        hanoi(n - k, from, to, temp, dest);
        StdOut.println("Move disc " + k + " from " + to + " to " + dest);
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, String from, String to, String temp, String dest) {
        if (n == 0) return;
        hanoi(n - 1, from, temp, to, dest);
        StdOut.println("Move disc " + (n + 1) + " from " + from + " to " + to);
        hanoi(n - 1, temp, dest, from, to);

        /*
        Move disc 1 from A to B
        Move disc 2 from A to C
        Move disc 3 from A to D
        Move disc 2 from C to D
        Move disc 1 from B to D
        */

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}

