// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 1
// A LetterInventory stores information about the counts of different letters.
//     Client can get the count of any letter, set the count of any letter to
//     certain value, add two LetterInventory up, and subtract one LetterInventory
//     from another.

public class MyLetterInventory {

    public static final int LETTER_NUM = 26; // the number of alphabetical letter
    private int[] letterCounter; // the count of each letter
    private int size; // the sum of counts of all letters

    // post: construct a LetterInventory that stores counts of different
    //       letters in the given data. The casing of the given data is not
    //       considered.
    public MyLetterInventory(String data) {
        letterCounter = new int[LETTER_NUM];
        data = data.toLowerCase();

        // check each character in the String called data. If it is a letter,
        //     increment the count of that letter and increment the size.
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) { // it is a latin alphabet
                size++;
                letterCounter[data.charAt(i) - 'a']++;
            }
        }
    }

    // post: returns the sum of counts of all letters in this LetterInventory
    public int size() {
        return size;
    }

    // post: returns if the inventory of letter is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // pre: letter should be an alphabetical character (throws
    //      IllegalArgumentException if not)
    // post: returns the count of the given letter (case-insensitive)
    public int get(char letter) {
        checkLetter(letter);
        return letterCounter[Character.toLowerCase(letter) - 'a'];
    }

    // post: returns a string representation of the contents of the
    //       LetterInventory. The string representation consists of all the
    //       letter in the inventory in lowercase, alphabetical order,
    //       enclosed in square brackets. If the object is empty, return a
    //       empty pair of brackets.
    public String toString() {
        String result = "[";
        for (int i = 0; i < letterCounter.length; i++) {
            for (int j = 0; j < letterCounter[i]; j++) {
                result += (char) ('a' + i);
            }
        }
        result += ']';
        return result;
    }

    // pre: letter should be an alphabetical character and value >= 0
    //      (throw IllegalArgumentException if either of the two conditions
    //      are not satisfied)
    // post: sets the count for the given letter (case-insensitive) to the given value
    public void set(char letter, int value) {
        checkLetter(letter);
        checkValue(value);
        letter = Character.toLowerCase(letter);
        size = size - letterCounter[letter - 'a'] + value;
        letterCounter[letter - 'a'] = value;
    }

    // post: constructs and returns a new LetterInventory object that is the
    //       sum of this LetterInventory and the other given one. Sum means
    //       adding the counts of every letter from two LetterInventory
    //       objects into one.
    public MyLetterInventory add(MyLetterInventory other) {
        MyLetterInventory result = new MyLetterInventory("");
        for (int i = 0; i < letterCounter.length; i++) {
            result.letterCounter[i] = this.letterCounter[i] + other.letterCounter[i];
        }
        result.size = this.size + other.size;
        return result;
    }

    // post: constructs and returns a new LetterInventory object which is the
    //       subtraction of the other given LetterInventory from this one.
    //       If any count become negative, returns null. Subtraction means
    //       subtracting the counts of every letter in one LetterInventory
    //       from another.
    public MyLetterInventory subtract(MyLetterInventory other) {
        MyLetterInventory result = new MyLetterInventory("");
        for (int i = 0; i < letterCounter.length; i++) {
            result.letterCounter[i] = this.letterCounter[i] - other.letterCounter[i];
            if (result.letterCounter[i] < 0) {
                return null;
            }
        }
        result.size = this.size - other.size;
        return result;
    }

    // throws an IllegalArgumentException if the given character
    //     is not alphabetical
    private void checkLetter(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("input is not a letter");
        }
    }

    // throws an IllegalArgumentException if the given value is negative
    private void checkValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value: " + value);
        }
    }
}
