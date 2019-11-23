import java.util.*;

public class reverseHalfQueue {
    public static void main(String[] args) {
        int[] list = {1, 8, 7, 2, 9, 18, 12, 0};
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < list.length; i++) {
            q.add(list[i]);
        }
        System.out.println("before: " + q);
        reverseHalf(q);
        System.out.println("after: " + q);
    }

    public static void reverseHalf(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        boolean isOdd = false;
        for (int i = 0; i < q.size(); i++) {
            int current = q.remove();
            if (isOdd) {
                s.push(current);
            }
            isOdd = !isOdd;
            q.add(current);
        }
        isOdd = false;
        for (int i = 0; i < q.size(); i++) {
            int current = q.remove();
            if (isOdd) {
                q.add(s.pop());
            } else {
                q.add(current);
            }
            isOdd = !isOdd;
        }
    }
}
