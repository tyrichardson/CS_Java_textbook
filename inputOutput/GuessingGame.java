public class GuessingGame {
    public static void main(String[] args) {
        int secret = 1 + (int) Math.random() * 10;
        StdOut.print("I'm thinking of a number between 1 and 10.");
        StdOut.println();
        int guess = 0;
        while (guess != secret) {
            StdOut.print("What's your guess? ");
            guess = StdIn.readInt();
            if (guess == secret) {
                StdOut.println("You got it!");
                break;
            } else if (guess < secret) {
                StdOut.println("Too low.");
            } else {
                StdOut.println("Too high.");
            }
        }
    }
}
