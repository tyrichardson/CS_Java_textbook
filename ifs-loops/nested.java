class nested {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % j == 0) || (j % i == 0))
                    System.out.print("* ");
                else
                    System.out.print(" ");
            }
            System.out.println(i);
        }
        double income = Double.parseDouble(args[1]);
        double rate;
        if      (income < 0)
            rate = 0.00;
        else if (income < 8925)
            rate = 0.10;
        else if (income < 36250)
            rate = 0.15;
        else if (income < 87850)
            rate = 0.23;
        else if (income < 183250)
            rate = 0.28;
        else if (income < 398350)
            rate = 0.33;
        else if (income < 400000)
            rate = 0.35;
        else
            rate = 0.396;
        System.out.println("On your income of " + income + ", you owe " + income * rate + " tax.");
    
    }

}
