/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RecursionBasics_Factorial {
    public static long factorial(int n) {
        if (n == 1) return 1; //the base case; makes the loop stop
        return n * (factorial(n - 1)); //the reduction step; must converge with base case
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(factorial(n));
    }
}

/*
factorial(5)
    factorial(4)
        factorial(3)
            factorial(2)
                factorial(1)
                    return 1 to the previous call on the stack
                return 2*1 = 2
            return 3*2 = 6
    return 4*6 = 24
return 5*24 = 120

print --> 120
 */

