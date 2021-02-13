public class dotProduct { // dot product of two vectors of equal length
    public static void main(String[] args) {
        double[] a = { 99.0, 85.0, 98.0 };
        double[] b = { 98.0, 57.0, 79.0 };
        double sum = 0.0;
        for (int i = 0; i < 2; i++) {
            sum += a[i] * b[i];
        }
        System.out.println(sum);
    }
}
