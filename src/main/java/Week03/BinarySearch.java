package Week03;

public class BinarySearch {
    public static int binarySearch(int[] a, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

}
