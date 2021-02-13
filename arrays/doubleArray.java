public class doubleArray {
    public static void main(String[] args) {
        // 4-by-4 double array
        double[][] arr = 
        {
            { 99.0, 85.0, 98.0, 0.0 },
            { 98.0, 57.0, 79.0, 0.0 },
            { 92.0, 77.0, 74.0, 0.0 },
            { 0, 0, 0, 0 } 
        };
        // average the values in each row, save average in column 3
        for (int i = 0; i < 3; i++) {
            double sum = 0.0;
            for (int j = 0; j < 3; j++) {
                sum += arr[i][j];
                arr[i][3] = sum / 3;
            }
        }
        System.out.println(arr[0][3]);    
    }
}