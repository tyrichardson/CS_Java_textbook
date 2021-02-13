// Print prime factorization of value (n)

class factoring {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        for (long factor = 2; factor <= n/factor; factor++) {
            while (n % factor == 0) {
                n /= factor;
                System.out.print(factor + " ");
            }
        }
        if (n > 1) {
            System.out.print(n);
        }
        System.out.println();
    }
}

// 8 >>> 2 2 2
// 1024 >>> 2 2 2 2 2 2 2 2 2 2
// 67093 >>> 13 13 397
// 3757208 >>> 2 2 2 7 13 13 397
