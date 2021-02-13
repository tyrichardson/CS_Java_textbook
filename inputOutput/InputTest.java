public class InputTest {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
        double value = StdIn.readDouble();
        StdOut.printf("%.2f", value);
        StdOut.println();
        }
    }
}
