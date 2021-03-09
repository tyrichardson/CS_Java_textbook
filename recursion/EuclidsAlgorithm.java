/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class EuclidsAlgorithm {

    public static long gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        StdOut.println(gcd(p, q));
    }
}

//java-introcs EuclidsAlgorithm 102 68 --> 34
//java-introcs EuclidsAlgorithm 1440 408 --> 24

/*
gcd(1440, 408)
   gcd(408, 216)
      gcd(216, 192)
         gcd(192, 24)
            gcd(24, 0)
               return 24
            return 24
         return 24
      return 24
   return 24

 */

