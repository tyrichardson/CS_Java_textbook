public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0.0;
        for (int i = 1; i <= n; i++) {
            h += 1 / Math.pow((double) i, (double) r);
        }
        System.out.println(h);
    }
}