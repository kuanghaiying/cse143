import java.util.*;

public class IsPalindrome {
    public static void main(String[] args) {
        int[] arr = {3, 8, 17, 9, 17, 8, 3};
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        System.out.println(q + " : " + isPalindrome(q));
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int current = q.remove();
            s.push(current);
            q.add(current);
        }
        for (int i = 0; i < size; i++) {
            int num1 = s.pop();
            int num2 = q.remove();
            q.add(num2);
            if (num1 != num2) {
                return false;
            }
        }
        return true;
    }
}
