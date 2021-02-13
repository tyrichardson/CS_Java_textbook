class gamblersRuin {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        int bets = 0;
        int wins = 0;

        for (int t = 0; t < trials; t++) {
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5)
                    cash++;
                else
                    cash--;
            }
            if (cash == goal)
                wins++;
        }
        System.out.println(100 * wins / trials + "% wins");
        System.out.println("Avg # bets/hands played: " + bets / trials);
    }

}
// win / lose is random at 50-50 chance
// each bet is always $1

// java gamblersRuin 10 20 1000, >>> 50% wins / Avg # bets/hands played: 102
// java gamblersRuin 10 20 1000, >>> 51% wins / Avg # bets/hands played: 98

// java gamblersRuin 50 250 100, >>> 13% wins / Avg # bets/hands played: 8715
// java gamblersRuin 50 250 100, >>> 18% wins / Avg # bets/hands played: 9370

// java gamblersRuin 500 2500 100, >>> 22% wins / Avg # bets/hands played: 920045
// java gamblersRuin 500 2500 100, >>> 20% wins / Avg # bets/hands played: 945326