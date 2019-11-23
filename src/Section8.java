import javax.swing.*;
import java.util.*;

public class Section8 {
    public static void main(String[] args) {
        String[] strList = {"to", "be", "or", "not", "that", "is", "the", "question"};
        Set<String> set = new HashSet<>();
        for (String str : strList) {
            set.add(str);
        }
        Map<Integer, Set<String>> map = split(set);
        System.out.println(map);
    }

    public static int maxLength(Set<String> set) {
        int max = 0;
        for (String str : set) {
            int length = str.length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public static int numlnCommon(List<Integer> list1, List<Integer> list2) {
        int countUnique = 0;
        Set<Integer> set1 = new HashSet<>();
        for (int num : list1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : list2) {
            set2.add(num);
        }
        for (int num : set1) {
            if (set2.contains(num)) {
                countUnique++;
            }
        }
        return countUnique;
    }

    public static void removeEvenLength(Set<String> set) {
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            if (str.length() % 2 == 0) {
                itr.remove();
            }
        }
    }

    public static void removeNumsFromSet(Set<Integer> set1, Set<Integer> set2) {
        Iterator<Integer> itr = set1.iterator();
        while (itr.hasNext()) {
            int num = itr.next();
            if (set2.contains(num)) {
                itr.remove();
            }
        }
    }

    public static void remvoeNumsFromMap(Map<Integer, String> map, Set<Integer> set) {
        for (int value : set) {
            if (map.containsKey(value)) {
                map.remove(value);
            }
        }
    }

    public static boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<String>();
        for (String value : map.values()) {
            if (values.contains(value)) {
                return false;
            } else {
                values.add(value);
            }
        }
        return true;
    }

    public static Map<Integer, Set<String>> split(Set<String> set) {
        Map<Integer, Set<String>> result = new HashMap<Integer, Set<String>>();
        for (String str : set) {
            int length = str.length();
            if (!result.containsKey(length)) {
                result.put(length, new HashSet<String>());
            }
            result.get(length).add(str);
        }
        return result;
    }

    public static boolean isInverse(Map<Integer, String> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (int key : map1.keySet()) {
            String currentValue = map1.get(key);
            if (!map2.containsKey(currentValue)) {
                return false;
            } else if (map2.get(currentValue) != key) {
                return false;
            }
        }
        return true;
    }


}
