import java.util.*;

public class CollapseStack {
    public static void main(String[] args) {
        int[] list = {0, 1, 2, 3, 4, 5, 6, 7};
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < list.length; i++) {
            s.push(list[i]);
        }
        System.out.println("Before collapse: " + s);
        collapse(s);
        System.out.println("After collapse:  " + s);
    }

    public static void collapse(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>();
        while (!s.isEmpty()) {
            int sum = s.pop();
            if (!s.isEmpty()) {
                sum += s.pop();
            }
            q.add(sum);
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
