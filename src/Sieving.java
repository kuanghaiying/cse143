import java.util.*;

public class Sieving {
    public static void main(String[] args) {
        List<Integer> prime = findPrime(10000);
        System.out.println(prime);
        for (int i : prime) {
            System.out.print(i + ", ");
        }
    }

    public static List<Integer> findPrime(int max) {
        List<Integer> num = new LinkedList<Integer>();
        List<Integer> prime = new LinkedList<Integer>();
        for (int i = 2; i <= max; i++) {
            num.add(i);
        }

        while (!num.isEmpty()) {
            int front = num.remove(0);
            prime.add(front);
            Iterator<Integer> iterate = num.iterator();
            while (iterate.hasNext()) {
                int current = iterate.next();
                if (current % front == 0) {
                    iterate.remove();
                }
            }
        }

        return prime;
    }
}
