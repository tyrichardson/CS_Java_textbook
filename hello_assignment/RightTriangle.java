public class RightTriangle {
    
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        double a2 = Math.pow(a, 2.0);
        double b2 = Math.pow(b, 2.0);
        double c2 = Math.pow(c, 2.0);

        System.out.println((a > 0 && b > 0 && c > 0) && (a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2));
    }
}