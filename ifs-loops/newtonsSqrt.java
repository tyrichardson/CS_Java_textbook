class newtonsSqrt {
    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        double EPSILON = 1e-15; //error tolerance
        double t = c;
        while (Math.abs(t - c / t) > EPSILON * t) {
            t = (c / t + t) / 2.0;
        }
        System.out.println("The square root of " + c + " is approx. " + t);
    }
}

// c = 2, >>> 1.414213562373095
// c = 4, >>> 2
// c = 2000000, >>> 1414.213562373095

