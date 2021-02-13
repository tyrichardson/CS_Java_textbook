public class RangeFilter {
    public static void main(String[] args) {
        int low = Integer.parseInt(args[0]);
        int high = Integer.parseInt(args[1]);
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value >= low && value <= high) {
                StdOut.print(value + " ");
            }
        }
        StdOut.println();
    }
}
