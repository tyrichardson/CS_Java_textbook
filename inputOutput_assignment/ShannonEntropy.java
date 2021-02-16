/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] mArr = new int[m];
        int counter = 0;

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            if (x >= 1 && x <= m) {
                mArr[x - 1] += 1;
            }
            counter++;
        }

        double h = 0.0;
        for (int i = 0; i < mArr.length; i++) {
            double p = (double) mArr[i];
            if ((p / counter) == 0) {
                h += 0.0;
            }
            else {
                h += (p / counter) * (Math.log((p) / counter) / Math.log(2));
            }
        }
        StdOut.printf("%.4f", (-h));
        StdOut.println();
    }
}
