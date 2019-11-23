import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = new int[128000];
        Random rand = new Random();
        for (int i = 0; i < 128000; i++) {
            list[i] = rand.nextInt(128000);
        }
        long startTime = System.currentTimeMillis();
        selectionSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time (ms): " + (endTime - startTime));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < min) {
                    min = list[j];
                    minIndex = j;
                }
            }
            swamp(list, i, minIndex);
        }
    }

    public static void swamp(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public static void mergeSort(int[] list) {
        //System.out.println("sorting: " + Arrays.toString(list));
        if (list.length > 1) {
            int[] left = Arrays.copyOfRange(list, 0, list.length / 2);
            int[] right = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(left);
            mergeSort(right);
            merge(list, left, right);
        }
    }

    public static void merge(int[] result, int[] left, int[] right) {
        //System.out.println("merging " + Arrays.toString(left) + " and " + Arrays.toString(right));
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (rightIndex >= right.length ||
                    (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
                result[i] = left[leftIndex];
                leftIndex++;
            } else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }
}
