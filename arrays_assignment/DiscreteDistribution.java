public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] intCopy = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            intCopy[i - 1] = Integer.parseInt(args[i]);
        }
        int[] sums = new int[intCopy.length + 1];
        for (int i = 0; i < intCopy.length + 1; i++) {
            if (i == 0) {
                sums[i] = 0;
            } else if (i == 1) {
                sums[i] = intCopy[i - 1];
            }
            else {
                sums[i] = intCopy[i - 1] + sums[i - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sums[sums.length - 1]);
            int counter = 1;
            for (int j = 0; j < sums.length - 1; j++) {
                if (r >= sums[j] && r < sums[j + 1]) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
        }
    }
}
