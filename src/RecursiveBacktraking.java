import java.util.*;

public class RecursiveBacktraking {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            list.add(n);
        }
        printSubsets(arr);
    }

    public static void arrangements(List<String> names) {
        arrangements(names, new ArrayList<>());
    }

    private static void arrangements(List<String> names, List<String> result) {
        if (names.size() == 0) {
            System.out.println(result);
        } else {
            for (int i = 0; i < names.size(); i++) {
//                System.out.println("##bofore:");
//                System.out.println("names: " + names);
//                System.out.println("result: " + result);
//                System.out.println();
                String person = names.remove(i);
                result.add(person);
                arrangements(names, result);
                result.remove(result.size() - 1);
                names.add(i, person);
//                System.out.println("##after:");
//                System.out.println("names: " + names);
//                System.out.println("result: " + result);
//                System.out.println();
            }
        }
    }

    public static void arrangements2(List<String> names, String name1, String name2) {
        arrangements2(names, new ArrayList<>(), name1, name2);
    }

    private static void arrangements2(List<String> names, List<String> result,
                                      String name1, String name2) {
        if (names.size() == 0) {
            System.out.println(result);
        } else {
            for (int i = 0; i < names.size(); i++) {
                String person = names.remove(i);
                if (result.isEmpty() ||
                        (!(person.equals(name1) && result.get(result.size() - 1).equals(name2)) &&
                                !(person.equals(name2) && result.get(result.size() - 1).equals(name1)))) {
                    result.add(person);
                    arrangements2(names, result, name1, name2);
                    result.remove(result.size() - 1);
                }
                names.add(i, person);
            }
        }
    }

    public static void knapsack(List<Integer> list, int sum) {
        knapsack(list, new ArrayList<>(), sum);
    }

    private static void knapsack(List<Integer> list, List<Integer> result, int sum) {
        if (sum == 0) {
            System.out.println(result);
        } else {
            for (int n : list) {
                if (sum >= n) {
                    result.add(n);
                    knapsack(list, result, sum - n);
                    result.remove(result.size() - 1);
                }
            }
        }
    }

    public static void printSquares(int n) {
        printSquares(n, new TreeSet<>(), 1);
    }

    private static void printSquares(int sum, Set<Integer> result, int min) {
        if (sum == 0) {
            System.out.println(result);
        } else {
            for (int i = min; i <= (int) Math.sqrt(sum); i++) {
                result.add(i);
                printSquares(sum - i * i, result, i + 1);
                result.remove(i);
            }
        }
    }

    public static void printBinary(int n) {
        printBinary(n, "");
    }

    private static void printBinary(int n, String result) {
        if (n == 0) {
            System.out.println(result);
        } else {
            printBinary(n - 1, result + "0");
            printBinary(n - 1, result + "1");
        }
    }

    public static void printSubsets(int[] nums) {
        Stack<Integer> result = new Stack<>();
        printSubsets(result, nums, 0);
    }

    private static void printSubsets(Stack<Integer> result, int[] nums, int index) {
        if (index >= nums.length) {
            System.out.println(result);
        } else {
            printSubsets(result, nums, index + 1);
            result.add(nums[index]);
            printSubsets(result, nums, index + 1);
            result.pop();
        }
    }
}
