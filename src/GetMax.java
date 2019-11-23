import java.util.*;

public class GetMax {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 11, 5};
        int[] arr2 = {2, 10, 3, 6};
        Stack<Integer> s = new Stack<>();
        for (int value : arr1) {
            s.push(value);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int value : arr2) {
            q.add(value);
        }
        System.out.println(getMax(s, q));
        System.out.println(s);
        System.out.println(q);
    }

    public static int getMax(Stack<Integer> s, Queue<Integer> q) {
        Stack<Integer> combination = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            combination.push(curr);
            q.add(curr);
        }
        while (!s.isEmpty()) {
            combination.push(s.pop());
        }
        int max = 0;
        while (!combination.isEmpty()) {
            int top = combination.pop();
            if (top > max) {
                max = top;
            }
            s.push(top);
        }
        for (int i = 0; i < size; i++) {
            s.pop();
        }
        return max;
    }
}
