public class RandomSeq {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%10.5f", (Math.random()));
            StdOut.println();
        }
    }
}