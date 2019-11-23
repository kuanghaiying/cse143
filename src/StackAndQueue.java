import java.util.*;

public class StackAndQueue {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {};
        char[] arr3= {'(', '[', '(', ')', '(', '(', ']', ')'};
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        Queue<Character> ch = new LinkedList<>();
         // Stack<Integer> s2 = new Stack<>();
        for (int n : arr1) {
            s.push(n);
        }
//        for (int value : arr2) {
//            s2.push(value);
//        }
        alternatingReverse(s);
        System.out.println(s);

    }

    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
        if (i < 0 || i > j || j > s.size()) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> result = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int size = s.size();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int index = 0; index < i; index++) {
            s.push(q.remove());
        }
        for (int index = i; index < j; index++) {
            result.push(q.remove());
        }
        for (int index = j; index < size; index++) {
            s.push(q.remove());
        }
        return result;
    }

    public static void sortPairs(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
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
            int n1 = q.remove();
            if (!q.isEmpty()) {
                int n2 = q.remove();
                if (n1 > n2) {
                    s.push(n2);
                    s.push(n1);
                } else {
                    s.push(n1);
                    s.push(n2);
                }
            } else {
                s.push(n1);
            }
        }
    }

    public static void separate(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 2; i >= 0; i--) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int n = q.remove();
                if (n % 3 == i) {
                    s.push(n);
                } else {
                    q.add(n);
                }
            }
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void reorder(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        int negative = 0;
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            if (n < 0) {
                s.push(n);
                negative++;
            } else {
                q.add(n);
            }
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < size - negative; i++) {
            q.add(q.remove());
        }
    }

    public static int removeMin(Stack<Integer> s) {
        int min = 0;
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        if (!s.isEmpty()) {
            min = s.pop();
            q.add(min);
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (curr < min) {
                min = curr;
            }
            q.add(curr);
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (curr != min) {
                q.add(curr);
            }
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        return min;
    }

    public static void rearrangeDuplicates(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        int last = 0;
        if (!q.isEmpty()) {
            last = q.remove();
            s.push(last);
        }
        for (int i = 1; i < size; i++) {
            int curr = q.remove();
            if (curr == last) {
                q.add(curr);
            } else {
                s.push(curr);
                last = curr;
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
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void rearrange(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (curr % 2 == 0) {
                s.push(curr);
            } else {
                q.add(curr);
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
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static Stack<Integer> pushNumTimes(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 1; i <= size; i++) {
            s.push(q.remove() * i);
        }
//        while (!s.isEmpty()) {
//            q.add(s.pop());
//        }
//        while (!q.isEmpty()) {
//            s.push(q.remove());
//        }
        return s;
    }

    public static int parityMachines(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.size() != s2.size()) {
            throw new IllegalArgumentException();
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        while (!s1.isEmpty()) {
            int n1 = s1.pop();
            int n2 = s2.pop();
            if (n1 % 2 == n2 % 2) {
                count++;
            }
            q.add(n1);
            q.add(n2);
        }
        int size = q.size();
        for (int i = 1; i <= size; i++) {
            if (i % 2 != 0) {
                s1.push(q.remove());
            } else {
                s2.push(q.remove());
            }
        }
        while (!s1.isEmpty()) {
            q.add(s1.pop());
        }
        while (!q.isEmpty()) {
            s1.push(q.remove());
        }
        while (!s2.isEmpty()) {
            q.add(s2.pop());
        }
        while (!q.isEmpty()) {
            s2.push(q.remove());
        }
        return count;
    }

    public static int numUnique(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int last = 0;
        if (!s.isEmpty()) {
            last = s.pop();
            q.add(last);
            count++;
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (curr != last) {
                count++;
                last = curr;
            }
            q.add(curr);
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
        return count;
    }

    public static void maxToTop(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        if (!s.isEmpty()) {
            max = s.pop();
            q.add(max);
        }
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            if (n > max) {
                max = n;
            }
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            if (n != max) {
                q.add(n);
            } else {
                s.push(n);
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

    public static void compressDuplicates(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        int last = 0;
        if (!s.isEmpty()) {
            last = s.pop();
            q.add(last);
        }
        while (!s.isEmpty()) {
            int n = s.pop();
            if (n != last) {
                q.add(count);
                q.add(n);
                count = 1;
                last = n;
            } else {
                count++;
            }
        }
        q.add(count);
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

    public static void evensToBack(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            if (n % 2 != 0) {
                s.push(n);
            } else {
                q.add(n);
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
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void expand(Queue<Character> q) {
        int size = q.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            char curr = q.remove();
            if (curr == '(' || curr == '[') {
                count++;
            } else if (curr == ')') {
                count--;
            }
            q.add(curr);
        }
        for (int i = 0; i < size; i++) {
            char curr = q.remove();
            if (curr == '[') {
                q.add('(');
            } else if (curr == ']') {
                for (int j = 0; j < count; j++) {
                    q.add(')');
                }
            } else {
                q.add(curr);
            }
        }
    }

    public static void makeSortedSequence(Queue<Integer> q) {
        int size = q.size();
        int last = 0;
        Stack<Integer> s = new Stack<>();
        if (size != 0) {
            last = q.remove();
            s.push(last);
        }
        for (int i = 1; i < size; i++) {
            int curr = q.remove();
            if (curr >= last) {
                s.push(curr);
                last = curr;
            } else {
                q.add(curr);
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
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static boolean isPairwiseConsecutive(Stack<Integer> s) {
        boolean result = true;
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        int size = q.size();
        for (int i = 0; i < size - 1; i += 2) {
            int n1 = q.remove();
            int n2 = q.remove();
            if (Math.abs(n1 - n2) != 1) {
                result = false;
            }
            s.push(n1);
            s.push(n2);
        }
        if (!q.isEmpty()) {
            s.push(q.remove());
        }
        return result;
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
        for (int i = 1; i <= size; i++) {
            if (i % 2 == 0) {
                s.push(q.remove());
            } else {
                q.add(q.remove());
            }
        }
        System.out.println("s: " + s);
        size = q.size();
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
            q.add(s.pop());
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
