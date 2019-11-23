// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 4
// HangmanManager allows clients to manage an evil version hangman game, which
//     does not pick a word until it is forced to. It keeps track of the state
//     of the game, including the current words set being considered, the
//     letters that have been guessed by players, how many wrong guesses is
//     allowed, and the current words pattern.

import java.util.*;

public class HangmanManager {
    private Set<String> currentWords;
    private Set<Character> letterGuessed;
    private int guessesLeftTime;
    private String currentPattern;

    // pre: 1)length >= 1, max >= 0 (throw an IllegalArgumentException if not)
    //      2)dictionary is a collection of nonempty strings composed entirely
    //      of lowercase letters
    // post: constructs a new HangmanManger. Initializes the words set as
    //       the words of given length in given dictionary and initializes
    //       the pattern as pure dashes. Also, sets the maximum number of
    //       wrong guesses as the given max.
    public HangmanManager(Collection<String> dictionary, int length, int max) {
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException();
        }
        letterGuessed = new TreeSet<Character>();
        currentWords = new TreeSet<String>();
        // add words with given length in the dictionary into the initial
        //     words set
        for (String word : dictionary) {
            if (word.length() == length) {
                currentWords.add(word);
            }
        }
        currentPattern = "-";
        for (int i = 1; i < length; i++) {
            currentPattern += " -";
        }
        guessesLeftTime = max;
    }

    // post: returns the current set of words being considered by the
    //       hangman manager
    public Set<String> words() {
        return currentWords;
    }

    // post: returns the number of wrong guesses the player can still make
    public int guessesLeft() {
        return guessesLeftTime;
    }

    // post: returns the current set of letters that have been guessed
    //       by the user
    public Set<Character> guesses() {
        return letterGuessed;
    }

    // pre: the set of current words is not empty (throw an
    //      IllegalStateException if not)
    // post: returns the current pattern to be displayed for the hangman game
    //       considering guesses that have been made. The pattern consists of
    //       dashed (letters that have not yet been guessed) and letters (that
    //       have been guessed correctly) with a space between each other.
    //       There are not leading or trailing spaces.
    public String pattern() {
        if (currentWords.isEmpty()) {
            throw new IllegalStateException();
        }
        return currentPattern;
    }

    // pre: 1)left guess time >= 1, current words considered is not empty
    //          (throw an IllegalStateException if either is not satisfied)
    //      2)the given guess has not been guessed before (throw an
    //          IllegalArgumentException if this condition is not satisfied and
    //          the conditions in (1) are satisfied)
    //      3)given guess is lowercase letter
    // post: records the given guess, updates the pattern and the set of words
    //       that is going to be used in the future using the given guess, and
    //       returns the number of occurrences of guessed letter in the new
    //       pattern
    public int record(char guess) {
        if (guessesLeftTime < 1 || currentWords.isEmpty()) {
            throw new IllegalStateException();
        } else if (letterGuessed.contains(guess)) {
            throw new IllegalArgumentException();
        }
        letterGuessed.add(guess);
        // classify all words in the current set into different patterns
        //     considering the current guess
        Map<String, Set<String>> wordsPatterns = groupWords(guess);
        choosePattern(wordsPatterns);
        currentWords = wordsPatterns.get(currentPattern); // update the words set
        // if the guess is not in the current pattern, decrement the
        //     remaining guess time
        if (currentPattern.indexOf(guess) == -1) {
            guessesLeftTime--;
        }
        return letterOccursTime(guess);
    }

    // post: groups the current words set with the new pattern considering the
    //       current guessed letter and returns the new map between patterns
    //       and words families
    private Map<String, Set<String>> groupWords(char targetLetter) {
        Map<String, Set<String>> wordsPatterns = new TreeMap<String, Set<String>>();
        for (String word : currentWords) {
            String pattern = producePattern(word, targetLetter);
            if (!wordsPatterns.containsKey(pattern)) {
                wordsPatterns.put(pattern, new TreeSet<String>());
            }
            wordsPatterns.get(pattern).add(word);
        }
        return wordsPatterns;
    }

    // post: returns a new pattern, using given word and target letter,
    //       based on the previous pattern. It retains the previous format (the
    //       letter that has been found) and update the pattern with the new
    //       letter just guessed.
    private String producePattern(String word, char targetLetter) {
        String pattern = currentPattern;
        for (int i  = 0; i < currentPattern.length(); i += 2) {
            if (word.charAt(i / 2) == targetLetter) {
                pattern = pattern.substring(0, i) + word.charAt(i / 2) +
                          pattern.substring(i + 1);
            }
        }
        return pattern;
    }

    // post: finds the pattern with the most members and updates the
    //       currentPattern to the pattern it chose. If there is a tie,
    //       choose the first one that occurs.
    private void choosePattern(Map<String, Set<String>> wordsPatterns) {
        int maxWordNum = 0;
        for (String pattern : wordsPatterns.keySet()) {
            int currentWordNum = wordsPatterns.get(pattern).size();
            if (currentWordNum > maxWordNum) {
                currentPattern = pattern;
                maxWordNum = currentWordNum;
            }
        }
    }

    // post: returns the time the given letter occurs in the given pattern
    private int letterOccursTime(char targetLetter) {
        int count = 0;
        for (int i = 0; i < currentPattern.length(); i += 2) {
            if (currentPattern.charAt(i) == targetLetter) {
                count++;
            }
        }
        return count;
    }
}
