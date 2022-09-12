package Week02;
import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        int count = 0;

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            count++;
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }

            if (uf.count() == 1) {
                System.out.println(count);
                break;
            }
        }

        if (uf.count() > 1)
            System.out.println("FAILED");
    }
}
