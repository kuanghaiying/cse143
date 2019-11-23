import java.util.*;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {4, 7, -11, 12, 15, -18, -22, 55, -102, 107};
        Queue<Integer> q = new LinkedList<>();
        for (int num : arr) {
            q.add(num);
        }
        System.out.println(q);
        sort(q);
        System.out.println(q);
    }

    public static void sort(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int sizeOfQueue = q.size();
        int positive = 0;
        for (int i = 0; i < sizeOfQueue; i++) {
            int curr = q.remove();
            if (curr < 0) {
                s.push(curr);
            } else {
                q.add(curr);
                positive++;
            }
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < positive; i++) {
            q.add(q.remove());
        }
    }
}
