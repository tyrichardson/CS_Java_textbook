public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int counter = 0;
        double a = 0.0;
        double b = 0.0;
        int aInt = 0;
        int bInt = 0;
        System.out.println("(" + aInt + ", " + bInt + ")");
        while ((aInt + bInt) != r) {
            double randomNum = Math.random();
            if (randomNum > 0.75) {
                a++;
            } else if (randomNum > 0.5) {
                a--;
            } else if (randomNum > 0.25) {
                b++;
            } else {
                b--;
            }
            aInt = (int) a;
            bInt = (int) b;
            System.out.println("(" + aInt + ", " + bInt + ")");
            aInt = (int) Math.abs(a);
            bInt = (int) Math.abs(b);
            counter++;
        }
        System.out.println("steps = " + counter);
    }
}