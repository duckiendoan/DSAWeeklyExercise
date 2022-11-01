package Week11;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/missing-numbers
public class MissingNumbers {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freqMapA = new HashMap<>();
        for (Integer a: arr) {
            freqMapA.put(a, freqMapA.getOrDefault(a, 0) + 1);
        }

        for (Integer b: brr) {
            int freq = freqMapA.getOrDefault(b, 0);
            if (freq <= 0) {
                res.add(b);
                freq = brr.size();
            }
            freqMapA.put(b, freq - 1);
        }

        Collections.sort(res);
        return res;
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0, j = 0;
        while (i < arr.size() && j < brr.size()) {
            if (arr.get(i).equals(brr.get(j))) {
                int next_i = nextElement(arr, i);
                int next_j = nextElement(brr, j);
                if ((next_j - j) > (next_i - i))
                    res.add(arr.get(i));
                i = next_i;
                j = next_j;
            } else if (arr.get(i) < brr.get(j)) {
                i = nextElement(arr, i);
            } else {
                res.add(brr.get(j));
                j = nextElement(brr, j);
            }
        }
        Collections.sort(res);
        return res;
    }

    private static int nextElement(List<Integer> arr, int i) {
        while (i + 1 < arr.size() && arr.get(i + 1).equals(arr.get(i))) {
            i++;
        }
        if (i + 1 == arr.size()) return arr.size();
        return i + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = missingNumbers2(arr, brr);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n");
        bufferedReader.close();
    }
}
