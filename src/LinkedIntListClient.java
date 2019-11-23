public class LinkedIntListClient {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        LinkedIntList list2 = new LinkedIntList();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {9};
        for (int n : arr1) {
            list.add(n);
        }
        for (int n : arr2) {
            list2.add(n);
        }
        list.removeEveryIthElement(1);
        System.out.println(list);
    }
}
