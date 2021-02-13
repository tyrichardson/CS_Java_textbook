class convertToBaseX {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]); // value to convert
        int base = Integer.parseInt(args[1]); // range: 2 - 16

        while (base <= n / 2) { //makes base the largest base of 2 <= n
            base *= 2;
        }
        
        while (base > 0) { //move through powers of base in decreasing order
            if (n < base) {
                System.out.print(0);
            } else {
                System.out.print(1);
                n -= base;
            }
            base /= 2;
        }
        System.out.println();
    }
}

// n = 
// n = 
