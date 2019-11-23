import java.util.*;

public class ReverseFirstK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Queue<Integer> q = new LinkedList<>();
        for (int num : arr) {
            q.add(num);
        }
        System.out.println(q);
        reverseFirstK(4, q);
        System.out.println(q);
    }

    public static void reverseFirstK(int k, Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }
}
