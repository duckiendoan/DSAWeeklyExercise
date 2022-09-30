package Week07;

public class PriorityQueue {
    private final int[] q;
    private int m;

    public PriorityQueue(int k) {
        q = new int[k];
        m = 0;
    }

    public void insert(int p) throws Exception{
        if (m == q.length)
            throw new Exception("Heap Overflow");
        int i = 0;
        for (; i < m; i++)
            if (q[i] >= p) break;
        // Insert before q[i]
        for (int j = m; j > i; j--)
            q[j] = q[j - 1];
        q[i] = p;
        m++;
    }

    public int deleteMin() {
        int min = q[0];
        for (int i = 0; i < m; i++)
            q[i] = q[i + 1];
        m--;
        return min;
    }

    public static void main(String[] args) throws Exception{
        PriorityQueue pq = new PriorityQueue(100);
        pq.insert(10);
        pq.insert(2);
        for (int i = 0; i < 10; i++)
            pq.insert(i);
        for (int i = 0; i < 5; i++)
            System.out.println(pq.deleteMin());
        System.out.println();
        for (int i = 3; i < 10; i++)
            pq.insert(i);
        for (int i = 0; i < 5; i++)
            System.out.println(pq.deleteMin());
    }
}
