package Week08;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-reverse/problem
public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if (isPalidrome(A, 0, A.length() - 1))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    private static boolean isPalidrome(String A, int i, int j) {
        if (i >= j) return true;
        if (A.charAt(i) == A.charAt(j)) return isPalidrome(A, i + 1, j - 1);
        return false;
    }
}
