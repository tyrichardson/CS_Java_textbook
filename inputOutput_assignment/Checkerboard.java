/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = n;
        double radius = p / (2 * p);
        StdDraw.setScale(0.0, p);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i % 2 == 0) == (j % 2 == 0)) {
                    StdDraw.setPenColor(Color.BLUE);
                }
                else {
                    StdDraw.setPenColor(Color.LIGHT_GRAY);
                }
                StdDraw.filledSquare(((double) i) + 0.5, ((double) j) + 0.5, radius);
            }
        }
    }
}
