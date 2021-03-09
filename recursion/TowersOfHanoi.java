/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TowersOfHanoi {
    public static void moves(int n, boolean left) {
        if (n == 0) return;
        moves(n - 1, !left);
        if (left) StdOut.println(n + " left");
        else StdOut.println(n + " right");
        moves(n - 1, !left);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves(n, true);
    }
}

/*
moves(2, true)
    moves(1, false)
        moves(0, true)
        returns nothing to moves(1, false)
     --> 1 right
 --> 2 left
 moves(1, false)
    moves(0, true)
    returns nothing to moves(1, false)
 --> 1 right
 */
