public class playingCards {
    public static void main(String[] args) {
        // declare, create, and initialize arrays; assign array values to variables
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int i = (int) (Math.random() * ranks.length);
        int j = (int) (Math.random() * suits.length);
        System.out.println(ranks[i] + " of " + suits[j]);

        // initialize array values at run-time
        String[] deckOfCards = new String[ranks.length * suits.length];
        for (int k = 0; k < ranks.length; k++) {
            for (int l = 0; l < suits.length; l++) {
                deckOfCards[suits.length * k + l] = ranks[k] + " of " + suits[l];
            }
        }
        System.out.print("deckOfCards = [ ");
        for (int m = 0; m < deckOfCards.length; m++) {
            System.out.println(deckOfCards[m] + " ");
        }
        System.out.println("]");

        // shuffling an array
        int n = deckOfCards.length;
        for (int o = 0; o < n; o++) {
            int r = o + (int) (Math.random() * (n - o));
            String temp = deckOfCards[o];
            deckOfCards[o] = deckOfCards[r];
            deckOfCards[r] = temp;
        }
        System.out.print("deckOfCards = [ ");
        for (int m = 0; m < deckOfCards.length; m++) {
            System.out.println(deckOfCards[m] + " ");
        }
        System.out.println("]");

    }
}
