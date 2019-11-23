import java.util.*;

public class StackQueueRemove {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        System.out.println(s);
    }

    public int removeMin(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>();
        int current = s.pop();
        q.add(current);
        int min = current;
        while (!s.isEmpty()) {
            current = s.pop();
            q.add(current);
            if (current < min) {
                min = current;
            }
        }

        while (!q.isEmpty()) {
            current = q.remove();
            if (current != min) {
                s.push(current);
            }
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        return min;
    }
}
