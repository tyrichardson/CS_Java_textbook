class convertToBinary {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // value to convert
        int power = 1; // binary scale (...64 32 16 8 4 2 1)

        while (power <= n / 2) {
            power *= 2;
        }
        //makes power the largest power of 2 <= n

        while (power > 0) { //move through powers of 2 in decreasing order
            if (n < power) {
                System.out.print(0);
            } else {
                System.out.print(1);
                n -= power;
            }
            power /= 2;
        }
        System.out.println();
    }
}

// n = 19, >>> 10011
// n = 100000, >>> 11000011010100000
