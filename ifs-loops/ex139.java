public class ex139 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int counter = 0;
        for (int i = 1000; i <= n/i; i++) {
            if (counter % 5 == 0) {
                System.out.println();
            }
            System.out.print(i + " ");
            counter++;
        }
    }
}

