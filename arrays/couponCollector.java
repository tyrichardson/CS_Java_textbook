public class couponCollector { // add loop for number of trials (1 million+) to get average
                               // test is average = natural log (ln) of M + .57721 * M
                               // for M = 4, avg = 8
                               // for M = 13, avg = 41
                               // for M = 52, avg = 236
                               // formula by Laplace
                               // test to assess if a sequence is random
                                    
    public static void main(String[] args) {
        // generate random values in [0..n) until each value is found
        int n = Integer.parseInt(args[0]);
        boolean[] isCollected = new boolean[n];
        int count = 0;
        int distinct = 0;

        while (distinct < n) {
            // generate a coupon
            int r = (int) (Math.random() * n);
            count++;
            if (!isCollected[r]) {
                distinct++;
                isCollected[r] = true;
            }
        } // n distinct coupons found
        System.out.println(count);
    }
}
