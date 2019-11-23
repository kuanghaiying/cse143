import java.util.*;

public class ArrayIntListClient {
    public static void main(String[] args) {
        ArrayIntList list1 = new ArrayIntList();
        int[] arr1 = {1, 2, 3};
        // int[] arr2 = {};
        for (int value : arr1) {
            list1.add(value);
        }
        ArrayIntList result = list1.makePalindrome();
        System.out.println(result);
    }
}
