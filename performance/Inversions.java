/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Inversions {

    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (i < j && a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        if (k == 0) return a;

        if (k > 0 && k < n) {
            for (int i = 0; i < k; i++) {
                int temp = a[n - 1 - i];
                a[n - 1 - i] = a[n - 1 - i - 1];
                a[n - 1 - i - 1] = temp;
            }
            //    StdOut.println("count = " + count(a));
            return a;
        }
        else {
            int counter = 0;
            while (k > counter) {
                int m = 0;
                for (int i = 0; i < k; i++) {
                    if ((i * (i - 1)) / 2 <= k) {
                        m = i;
                    }
                    counter++;
                }
                //   StdOut.println("m = " + m);
                for (int i = 0; i < m / 2; i++) {
                    int temp = a[i];
                    a[i] = a[m - 1 - i];
                    a[m - 1 - i] = temp;
                    counter++;
                }
                if (k > count(a)) {
                    for (int i = 0; i < m - 1; i++) {
                        int temp = a[m - i];
                        a[m - i] = a[m - i - 1];
                        a[m - i - 1] = temp;
                    }
                }
            }
        }

        //   StdOut.println("count = " + count(a));
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
