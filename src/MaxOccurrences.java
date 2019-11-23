import java.util.*;

public class MaxOccurrences {
    public static void main(String[] args) {
        int[] value = {1, 1, 2, 2, 2, 3, 4};
        List<Integer> list = new ArrayList<>();
        for (int num : value) {
            list.add(num);
        }
        System.out.println(maxOccurrences(list));
    }

    public static int maxOccurrences(List<Integer> num) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int value : num) {
            if (!count.containsKey(value)) {
                count.put(value, 1);
            } else {
                count.put(value, count.get(value) + 1);
            }
        }
        int max = 0;
        int mode = 0;
        for (int key : count.keySet()) {
            if (count.get(key) > max) {
                max = count.get(key);
                mode = key;
            }
        }
        return mode;
    }
}
