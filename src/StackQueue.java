import java.util.*;

public class StackQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= 6; i++) {
            q.add(i * 3);
        }
        System.out.println(q);
        System.out.println("sum = " + sum(q));
        System.out.println("after sum: " + q);

        Stack<Integer> s = new Stack<Integer>();
        queueToStack(s, q);
        System.out.println("after queueToStack: s = " + s);
        System.out.println("                    q = " + q);


        q = new LinkedList<Integer>();
        stackToQueue(s, q);
        System.out.println("after stackToQueue: q = " + q);
        System.out.println("                    s = " + s);

        queueToStack(s, q);

        System.out.println("stack: " + s);
        System.out.println("sum of stack = " + sum(s));
        System.out.println("after sum: " + s);

    }

    public static void stackToQueue(Stack<Integer> s, Queue<Integer> q) {
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void queueToStack(Stack<Integer> s, Queue<Integer> q) {
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }

    public static int sum(Queue<Integer> q) {
        int sum = 0;
        for (int i = 0; i < q.size(); i++) {
            int current = q.remove();
            sum += current;
            q.add(current);
        }
        return sum;
    }

    public static int sum(Stack<Integer> s) {
        int sum = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        while (!s.isEmpty()) {
            int current = s.pop();
            sum += current;
            q.add(current);
        }

        queueToStack(s, q);
        stackToQueue(s, q);
        queueToStack(s, q);
        return sum;
    }

}
