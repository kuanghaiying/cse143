// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 6
// An AnagramSolver uses a dictionary to find all combinations of words that
//     have the same letters as the given phrase.

import java.util.*;

public class AnagramSolver {
    private Map<String, LetterInventory> wordsMap;
    private List<String> dictionary;

    // pre: the given dictionary is a nonempty collection of nonempty sequences
    //      of letters and it contains no duplicate
    // post: Constructs a new AnagramSolver using the given list as its
    //       dictionary.
    // parameter: "dictionary" is the words source from which the AnagramSolver
    //            chooses the anagram
    public AnagramSolver(List<String> dictionary) {
        this.wordsMap = new HashMap<String, LetterInventory>();
        this.dictionary = dictionary;
        for (String word : dictionary) {
            wordsMap.put(word, new LetterInventory(word));
        }
    }

    // pre: max >= 0 (throw an IllegalArgumentException if not)
    // post: Print all the combinations of words in the dictionary that has the
    //       same letters as the given text, ignoring spaces and case, to the
    //       console. Each combination contains at most max number of words. If
    //       max is 0, it will print unlimited number of words. Words output in
    //       each combination are separated by comma and closed by brackets.
    //       Each combination is in its own line.
    public void print(String text, int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        List<String> reducedDictionary = new ArrayList<String>();
        LetterInventory textInventory = new LetterInventory(text);
        for (String word : dictionary) {
            if (textInventory.subtract(wordsMap.get(word)) != null) {
                reducedDictionary.add(word);
            }
        }
        explore(textInventory, max, new Stack<String>(), reducedDictionary);
    }

    // post: Print all combinations of words in the reducedDictionary that has
    //       exactly the same letter as in the given textInventory, ignoring
    //       spaces and case, to the console. Each words combination contains
    //       at most max number of words. Words output in each combination are
    //       separated by comma and closed by brackets. Each combination is in
    //       its own line.
    // parameter: "result" is the current word combination
    private void explore(LetterInventory textInventory, int max, Stack<String> result,
                         List<String> reducedDictionary) {
        if (textInventory.size() == 0) {
            System.out.println(result);
        } else if (result.size() < max || max == 0) {
            for (String word : reducedDictionary) {
                LetterInventory remainder = textInventory.subtract(wordsMap.get(word));
                if (remainder != null) {
                    result.add(word);
                    explore(remainder, max, result, reducedDictionary);
                    result.pop();
                }
            }
        }
    }
}
