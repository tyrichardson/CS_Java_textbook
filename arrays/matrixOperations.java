public class matrixOperations {
    public static void main(String[] args) {
        double[][] a = { { 99.0, 85.0, 98.0 }, { 79.0, 75.0, 78.0 }, { 69.0, 65.0, 68.0 } };
        double[][] b = { { 98.0, 57.0, 79.0 }, { 58.0, 47.0, 39.0 }, { 18.0, 27.0, 39.0 } };
        // add two matrices to create a third
        double[][] c = new double[3][3];
        for (int i = 0; i < a.length; i++) { // a.length gives how many rows
            for (int j = 0; j < a[i].length; j++) {// a[i].length gives how many columns in row a[i]
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println(c[0][2]);

        // multiply two matrices to create a third
        // each value in d array = the dot product of a row and b column
        // e.g. d[1][2] = dot product of values in a row 1 and b column 2
        // code:
        // double[] a = { 99.0, 85.0, 98.0 };
        // double[] b = { 98.0, 57.0, 79.0 };
        // double sum = 0.0;
        // for (int i = 0; i < 2; i++) {
        //    sum += a[i] * b[i];
        // }
        // System.out.println(sum);
        double[][] d = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    d[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println(d[0][2]);
        System.out.print(d[0][0] + ", " + d[0][1] + ", " + d[0][2]);
        System.out.println();
        System.out.print(d[1][0] + ", " + d[1][1] + ", " + d[1][2]);
        System.out.println();
        System.out.print(d[2][0] + ", " + d[2][1] + ", " + d[2][2]);
    }
}
