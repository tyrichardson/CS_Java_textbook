class ifsAndLoops {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            if (Math.random() < 0.5)
                System.out.println("Heads");
            else
                System.out.println("Tails");
            i++;
        }
        //the powers of 2
        int n = Integer.parseInt(args[0]);
        int power = 1;
        int j = 0;
        while (j <= n) {
            System.out.println("2 to the power of " + j + " = " + power);
            power = 2 * power;
            j++;
        }
        //the ruler function
        int m = Integer.parseInt(args[1]);
        String ruler = "1";
        for (int k = 2; k <= m; k++) {
            ruler += " " + k + " " + ruler;
        }
        System.out.println(ruler);
        
    }
}