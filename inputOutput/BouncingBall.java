/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class BouncingBall {
    public static void main(String[] args) {
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        double rx = 0.480, ry = 0.860, vx = 0.015, vy = 0.023, radius = 0.05;
        while (true) {
            if (Math.abs(rx + vx) + radius > 1.0) {
                vx = -vx;
            }
            if (Math.abs(ry + vy) + radius > 1.0) {
                vy = -vy;
            }
            rx += vx;
            ry += vy;
            StdDraw.clear();
            StdDraw.filledCircle(rx, ry, radius);
            StdDraw.show();
            StdDraw.pause(50);
        }
    }
}
