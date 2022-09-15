package Week03;
import java.util.List;

// https://www.hackerrank.com/challenges/sherlock-and-array
public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int rightSum = 0;
        for (int k: arr) {
            rightSum += k;
        }

        int leftSum = 0;
        for (int k: arr) {
            rightSum -= k;
            if (leftSum == rightSum)
                return "YES";
            leftSum += k;
        }
        return "NO";
    }
}
