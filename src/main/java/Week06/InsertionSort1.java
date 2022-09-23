package Week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/insertionsort1/problem
public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        n--;
        if (n > 0 && arr.get(n) < arr.get(n - 1)) {
            Integer tmp = arr.get(n);
            arr.set(n, arr.get(n - 1));
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            arr.set(n - 1, tmp);
            insertionSort1(n, arr);
        } else  {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        insertionSort1(n, arr);

        bufferedReader.close();
    }
}
