import java.io.*;
import java.util.*;

public class WordCount {
    public static final int OCCURRENCES = 100;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test3.txt"));
        Map<String, Integer> wordCountMap = getCount(input);

        boolean found = false;
        for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if (count > OCCURRENCES) {
                found = true;
                System.out.println("\"" + word + "\"" + " occurs " + count + " times.");
            }
        }

        if(!found) {
            System.out.println("No word occurs more than " + OCCURRENCES + " times.");
        }

    }

    public static Map<String, Integer> getCount(Scanner input) {
        Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();

        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }
}
