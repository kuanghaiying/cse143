import java.util.*;

public class Swap {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6, 7};
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for (int num : arr1) {
            s.push(num);
        }
        for (int num : arr2) {
            q.add(num);
        }
        System.out.println("s: " + s);
        System.out.println("q: " + q);
        System.out.println();
        swamp(s, q);
        System.out.println("s: " + s);
        System.out.println("q: " + q);
    }

    public static void swamp(Stack<Integer> s, Queue<Integer> q) {
        int queueSize = q.size();
        int stackSize = 0;
        while (!s.isEmpty()) {
            q.add(s.pop());
            stackSize++;
        }
        for (int i = 0; i < queueSize; i++) {
            s.push(q.remove());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        for (int i = 0; i < stackSize; i++) {
            q.add(s.pop());
        }
    }
}
