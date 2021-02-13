public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int counter = 0;
        int accumCount = 0;
        double a = 0.0;
        double b = 0.0;
        int aInt = 0;
        int bInt = 0;
        for (int t = 0; t < trials; t++) {
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
                aInt = (int) Math.abs(a);
                bInt = (int) Math.abs(b);
                counter++;
            }
            accumCount += counter;
        }
        System.out.println("average number of steps = " + (double) accumCount/trials);
    }
}