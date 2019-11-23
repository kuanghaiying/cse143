public class ArraySumRecursion {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        System.out.println(sum(num, 0));
    }

    public static int sum(int[] list, int index) {
        if (index >= list.length) {
            return 0;
        } else {
            return list[index] + sum(list, index + 1);
        }
    }
}
