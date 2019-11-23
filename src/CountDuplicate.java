import java.util.*;

public class CountDuplicate {
    public static void main(String[] args) {
        List<Integer> num = new LinkedList<Integer>();
        num.add(1);
        num.add(2);
        num.add(2);
        num.add(2);
        num.add(3);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(5);
        int duplicate = countDuplicate(num);
        System.out.println("duplicate: " + duplicate);
    }

    public static int countDuplicate(List<Integer> num) {
        int count = 0;
        Iterator<Integer> numIterator = num.iterator();
        int last = 0;
        if (numIterator.hasNext()) {
            last = numIterator.next();
        }

        while (numIterator.hasNext()) {
            int current = numIterator.next();
            if (current == last) {
                count++;
            }
            last = current;
        }

        return count;
    }
}
