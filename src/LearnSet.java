import java.util.*;

public class LearnSet {
    public static void main(String[] args) {
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            num.add(i);
        }
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
