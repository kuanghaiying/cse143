public class BinarySearch {
    public static void main(String[] args) {
        int[] list = new int[20];
        for (int i = 0; i < 20; i++) {
            list[i] = i * 2;
        }
        System.out.println("index: " + binarySearch(list, 12));
    }

    public static int binarySearch(int[] list, int target) {
        int min = 0;
        int max = list.length - 1;
        while (min <= max) {
            int middle = (max + min) / 2;
            if (list[middle] == target) {
                return middle;
            } else if (list[middle] > target) {
                max = middle + 1;
            } else {
                min = middle - 1; 
            }
            System.out.print(".");
        }
        return -1;
    }
}
