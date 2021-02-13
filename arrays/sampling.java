public class sampling {
    public static void main(String[] args) {
        // * Sampling without Replacement
        // * m = sample size
        // * n = range
        // * perm[] = permutation of 0 to n - 1
        
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[] perm = new int[n];

        for (int j = 0; j < n; j++) {
            perm[j] = j;
        }

        for (int i = 0; i < m; i++) {
            int r = i + (int) (Math.random() * (n - 1));
            int temp = perm[r];
            perm[r] = perm[i];
            perm[i] = temp;
        }

        for (int i = 0; i < m; i++) {
            System.out.print(perm[i] + " ");
        }
        
        System.out.println();

    }
}
