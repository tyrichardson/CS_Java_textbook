/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TestShapesText {
    public static void main(String[] args) {
        StdDraw.setScale(-0.1, 1.1);
        StdDraw.square(0.2, 0.8, 0.1);
        StdDraw.filledSquare(0.8, 0.8, 0.2);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0.8, 0.8, "white text");
        StdDraw.setPenColor();
        StdDraw.text(0.2, 0.5, "black text");
        double[] xd = { 0.1, 0.2, 0.3, 0.2 };
        double[] yd = { 0.2, 0.3, 0.2, 0.1 };
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledPolygon(xd, yd);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.setPenRadius(0.01);
        StdDraw.circle(0.8, 0.2, 0.2);
        // center of circle is: StdDraw.point(0.8, 0.2);
        // center line
        StdDraw.line(0.8, 0.15, 0.8, 0.4);
        // leg lines
        StdDraw.line(0.8, 0.15, 0.7, 0.03);
        StdDraw.line(0.8, 0.15, 0.9, 0.03);
        // arm line
        StdDraw.line(0.61, 0.25, 0.99, 0.25);
    }
}
