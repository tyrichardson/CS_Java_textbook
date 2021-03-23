/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 *  Corner cases:
 *      Throw an IllegalArgumentException in the constructor if any component is
 *      outside its prescribed range (0 to 359 for the hue, 0 to 100 for the
 *      saturation and brightness);
 *      Throw an IllegalArgumentException in distanceSquaredTo() if its argument is null.
 *      Example code:
 *      throw new IllegalArgumentException("the hue must be between 0 and 359");
 *
 **************************************************************************** */

public class ColorHSB {
    private final int hue, sat, bright;

    // Creates a color with hue h, saturation s, and brightness b.
    // 0 <= h <= 359; 0 <= s <= 100; 0 <= b >= 100
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("unacceptable value for h, s, and/or b");
        }
        hue = h;
        sat = s;
        bright = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    // HSB is a shade of gray if either or both its saturation or brightness is 0%.
    public boolean isGrayscale() {
        if (sat == 0 || bright == 0) return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    // min{(h1−h2)2,(360−|h1−h2|)2} + (s1−s2)2 + (b1−b2)2
    // For example, the squared distance between (350, 100, 45) and (0, 100, 50) is 102+02+52=125.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("argument for distanceSquareTo cannot be null.");
        }
        return Math.min((int) Math.pow((this.hue - that.hue), 2),
                        (int) Math.pow((360 - (Math.abs(this.hue - that.hue))), 2))
                + (int) Math.pow((this.sat - that.sat), 2) + (int) Math
                .pow((this.bright - that.bright), 2);
    }

    // Sample client
    // take three integer command-line arguments h, s, and b;
    // ColorHSB this = new ColorHSB(args[0], args[1], args[2]
    // read a list of pre-defined colors from standard input;
    //
    // print to standard output the pre-defined color that is closest to (h,s,b).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB thisColor = new ColorHSB(h, s, b);
        String finalName = "";
        ColorHSB finalColor = thisColor;
        int finalDist = 148881;
        while (!StdIn.isEmpty()) {
            String thatName = StdIn.readString();
            ColorHSB thatColor = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            int dist = thisColor.distanceSquaredTo(thatColor);
            if (dist < finalDist) {
                finalDist = dist;
                finalColor = thatColor;
                finalName = thatName;
            }
        }
        StdOut.println(finalName + " " + finalColor.toString());
    }
}
