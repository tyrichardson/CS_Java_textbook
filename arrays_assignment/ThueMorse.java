public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    array[i] = 0;
                } else if (i % 2 == 0) {
                    array[i] = array[i / 2];
                } else {
                    array[i] = 1 - array[i - 1];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i] == array[j]) {
                        System.out.print("+  ");
                    } else {
                        System.out.print("-  ");
                    }
                }
                System.out.println();
            }
    }
}