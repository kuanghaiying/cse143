import java.util.*;

public class AlternatingReverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Stack<Integer> s = new Stack<>();
        for (int value : arr) {
            s.push(value);
        }
        System.out.println("before: " + s);
        alternatingReverse(s);
        System.out.println("after: " + s);
    }

    public static void alternatingReverse(Stack<Integer> s) {
        if (s.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 != 0) {
                s.push(q.remove());
            } else {
                q.add(q.remove());
            }
        }
        for (int i = 0; i < size; i++) {
            if (i % 2 != 0) {
                q.add(s.pop());
            } else {
                q.add(q.remove());
            }
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }
}
