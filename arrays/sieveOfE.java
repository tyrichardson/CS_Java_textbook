public class sieveOfE { // Print the number of prime numbers <= n
    public static void main(String[] args) {
        // create a boolean array of length n with all values initialized to true
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n / 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n / 1; i++) {
            if (isPrime[i]) { // mark multiples of i as not prime
                for (int j = i; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        // count the primes
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        System.out.println("There are " + primeCount + " prime numbers in a range 0-" + n);
    }
}
