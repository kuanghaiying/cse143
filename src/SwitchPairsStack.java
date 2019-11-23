import java.util.*;

public class SwitchPairsStack {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
        }
        System.out.println("Before: " + s);
        switchPairs(s);
        System.out.println("After:  " + s);
    }

    public static void switchPairs(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            int num1 = q.remove();
            if (!q.isEmpty()) {
                int num2 = q.remove();
                s.push(num2);
            }
            s.push(num1);
        }
    }

    public static void switchPairs$(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            int num1 = s.pop();
            if (!s.isEmpty()) {
                int num2 = s.pop();
                q.add(num2);
            }
            q.add(num1);

        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }

    public static void switchPairs$$(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        while (!temp.isEmpty()) {
            int num1 = temp.pop();
            if (!temp.isEmpty()) {
                int num2 = temp.pop();
                s.push(num2);
            }
            s.push(num1);
        }
    }
}
