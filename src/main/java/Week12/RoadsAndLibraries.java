package Week12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/torque-and-development/problem
class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        if (c_lib <= c_road)
            return (long) c_lib * n;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
        for (List<Integer> edge: cities) {
            int v = edge.get(0);
            int w = edge.get(1);
            graph.get(v - 1).add(w - 1);
            graph.get(w - 1).add(v - 1);
        }

        int cc = 0;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(graph, i, marked);
                cc++;
            }
        }

        return ((long) (n - cc) * c_road) + ((long) c_lib * cc);
    }


    private static void dfs(List<List<Integer>> graph, int start, boolean[] marked) {
        marked[start] = true;
        for (int v: graph.get(start)) {
            if (!marked[v])
                dfs(graph, v, marked);
        }
    }
}

public class RoadsAndLibraries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}