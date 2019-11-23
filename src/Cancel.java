import java.util.*;

public class Cancel {
    public static void main(String[] args) {
        int[] num = {5, 4, 3, -1, -2, 2, 1};
        Stack<Integer> s = new Stack<>();
        for (int value : num) {
            s.push(value);
        }
        System.out.println(s);
        cancel$(s);
        System.out.println(s);
    }

    public static void cancel(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            System.out.println("s2: " + s2);
            int num1 = s1.pop();
            if (!s1.isEmpty()) {
                int num2  = s1.pop();
                if (num1 + num2 != 0) {
                    if (!s2.isEmpty()) {
                        if (s2.peek() + num1 != 0) {
                            s2.push(num1);
                        } else {
                            s2.pop();
                        }
                    } else {
                        s2.push(num1);
                    }
                    s1.push(num2); // return num2 to s1
                }
            } else {
                if (!s2.isEmpty()) {
                    if (s2.peek() + num1 != 0) {
                        s2.push(num1);
                    } else {
                        s2.pop();
                    }
                } else {
                    s2.push(num1);
                }
            }
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void cancel$(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            int top = s.pop();
            if (!s.isEmpty() && s.peek() + top == 0) {
                s.pop();
            } else if (!temp.isEmpty() && temp.peek() + top == 0) {
                temp.pop();
            } else {
                temp.push(top);
            }
        }
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}
