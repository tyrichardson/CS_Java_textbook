class sumBuilder {
    //example of building up a sum value using Harmonic Numbers: sum Hsubn = 1 + 1/2 +...+1/n
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println(sum);
    }
}
// n = 2, >>> 1.5
// n = 10, >>> 2.9289682539682538