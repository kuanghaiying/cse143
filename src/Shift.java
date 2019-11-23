import java.util.*;

public class Shift {
    public static void main(String[] args) {
        int[] arr = {7, 23, -7, 0, 22, -8, 4, 5};
        Stack<Integer> s = new Stack<>();
        for (int num : arr) {
            s.push(num);
        }
        System.out.println(s);
        rotateBy(4, s);
        System.out.println(s);


    }

    public static void shift(int n, Stack<Integer> s) {
        int size = 0;
        Queue<Integer> tempQueue = new LinkedList<>();
        while (!s.isEmpty()) {
            tempQueue.add(s.pop());
            size++;
        }
        for (int i = 0; i < size - n; i++) {
            s.push(tempQueue.remove());
        }
        while (!s.isEmpty()) {
            tempQueue.add(s.pop());
        }
        for (int i = 0; i < n; i++) {
            tempQueue.add(tempQueue.remove());
        }
        for (int i = 0 ; i < size - n; i++) {
            s.push(tempQueue.remove());
        }
        while (!tempQueue.isEmpty()) {
            s.push(tempQueue.remove());
        }
    }

    public static void rotateBy(int n, Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int size = 0;
        while (!s.isEmpty()) {
            q.add(s.pop());
            size++;
        }
        for (int i = 0; i < size - n; i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < n; i++) {
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
