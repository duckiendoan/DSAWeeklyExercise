package Week06;

import java.util.List;

public class InsertionSort2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr.get(j) < arr.get(j - 1)) {
                int tmp = arr.get(j);
                arr.set(j, arr.get(j - 1));
                arr.set(j - 1, tmp);
                j--;
            }
            printArray(arr);
        }
    }
    private static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
