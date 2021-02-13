public class arrayManipulation {
    public static void main(String[] args) {
        // create array with random numbers, print values
        double[] num = new double[5];
        for (int i = 0; i < num.length; i++) {
            num[i] = Math.random() * 10;
        }

        // print array values
        System.out.print("num = [ ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("]");

        // find max value in array
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        System.out.println("max value in num = " + max);

        // find average of values in array
        double sum = 0.0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        double average = sum / num.length;
        System.out.println("average of num values = " + average);

        // reverse order of values in array
        for (int i = 0; i < (num.length / 2); i++) {
            double temp = num[i];
            num[i] = num[num.length - 1 - i];
            num[num.length - 1 - i] = temp;
        }
        System.out.print("num in reversed order is: ");
        System.out.print("[ ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("]");
        
        // copy sequence of values from one array to another
        double[] numCopy = new double[5];
        for (int i = 0; i < num.length; i++) {
            numCopy[i] = num[i];
        }
        System.out.print("num = [ ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("]");

        System.out.print("numCopy = [ ");
        for (int i = 0; i < numCopy.length; i++) {
            System.out.print(numCopy[i] + " ");
        }
        System.out.println("]");
    }
}
