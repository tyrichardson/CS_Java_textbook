/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Curve {
    public static void main(String[] args) {
        int n = 50;
        StdDraw.setXscale(-1.0, n + 2);
        StdDraw.setYscale(-1.0, n + 2);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i <= n; i++) {
            // StdDraw.clear() clears previous image, so only one line shown
            StdDraw.line(0, n - i, i, 0);
            StdDraw.show();
            StdDraw.pause(50);

        }
    }
}
