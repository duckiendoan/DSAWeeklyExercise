package Week05;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    private static class SpecialIntQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void Enqueue(int num) {
            stack1.push(num);
        }

        public int Dequeue() {
            if (stack2.isEmpty())
                Move();
            return stack2.pop();
        }

        public int Peek() {
            if (stack2.isEmpty())
                Move();
            return stack2.peek();
        }

        private void Move() {
            while (!stack1.isEmpty()) {
                int p = stack1.pop();
                stack2.push(p);
            }
        }
    }

    public static void main(String[] args) {
        SpecialIntQueue queue = new SpecialIntQueue();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int num = scanner.nextInt();
                queue.Enqueue(num);
            } else if (type == 2) {
                queue.Dequeue();
            } else if (type == 3) {
                System.out.println(queue.Peek());
            }
        }
    }
}
