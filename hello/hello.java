class Hello {
    public static void main(String[] args) {
        System.out.print("Hello, World. This is ");
        System.out.println(args[0] + "." );
        System.out.print("Hello, ");
        System.out.print(args[1]);
        System.out.println("! This is World!");
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        int z = Integer.parseInt(args[4]);
        System.out.println((x % y == 0 || y % x == 0));
        int a = (int) (10 * Math.random());
        int b = (int) (10 * Math.random());
        int c = (int) (10 * Math.random());
        int d = (int) (10 * Math.random());
        int e = (int) (10 * Math.random());
        System.out.println("Five random values " + a + " " + b + " " + c + " " + d + " " + e + " ");
        System.out.println("Average of five random values = " + (a + b + c + d + e) / 5.0);
        double m1 = Math.min((double) a, (double) b);
        double m2 = Math.min(m1, (double) c);
        double m3 = Math.min(m2, (double) d);
        double m4 = Math.min(m3, (double) e);
        System.out.println("Min of five random values = " + m4);
        int minXY = Math.min(x, y);
        int MinYZ = Math.min(y, z);
        int foundMin = Math.min(minXY, MinYZ);
        System.out.println("found min of three values = " + foundMin);
        int maxXY = Math.max(x, y);
        int maxYZ = Math.max(y, z);
        int foundMax = Math.max(maxXY, maxYZ);
        System.out.println("found max of three values = " + foundMax);
        int secondVal;
        if(x != foundMin && x != foundMax) {
            secondVal = x;
        } else if(y != foundMin && y != foundMax) {
            secondVal = y;
        } else {
            secondVal = z;
        }
        System.out.println("Argument in order: " + foundMin + " " + secondVal + " " + foundMax);
    }
}

// javac hello.java
// java Hello Alice Bob # # #