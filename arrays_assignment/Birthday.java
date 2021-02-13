public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] people = new int[n + 2];
        for (int t = 0; t < trials; t++) {
            int counter = 0;
            boolean[] rInRoom = new boolean[n];
            while (true) {
                int r = (int) (Math.random() * n);
                counter++;
                if (rInRoom[r]) {
                    people[counter] += 1;
                    break;
                }
                rInRoom[r] = true;
                people[counter] += 0;
            }
        }
        int fraction = 0;
        for (int i = 1; i < people.length + 1; i++) {
            fraction += people[i];
            System.out.println(i + "\t" + people[i] + "\t" + (double) fraction / trials);
            if ((double) fraction / trials >= 0.5) {
                break;
            }
        }
    }
}
