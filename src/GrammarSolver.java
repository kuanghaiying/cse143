// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 5
// GrammarSolver stores grammar information, which is in standard BNF format.
//     It can performs tasks based on the grammar, including generating random
//     elements of the grammar.

import java.util.*;

public class GrammarSolver {
    public SortedMap<String, String[][]> grammarMap;

    // pre: given grammar is not empty, no two or more entries have the same
    //      nonterminal (throw an IllegalArgumentException if either is not
    //      satisfied)
    // post: Constructs a new GrammarSolver with given grammar as source
    //       information
    public GrammarSolver(List<String> grammar) {
        if (grammar.isEmpty()) {
            throw new IllegalArgumentException();
        }
        grammarMap = new TreeMap<String, String[][]>();
        for (String currentGrammar : grammar) {
            String[] splitGrammar = currentGrammar.split("::=");
            String nonterminal = splitGrammar[0];
            if (grammarMap.containsKey(nonterminal)) {
                throw new IllegalArgumentException();
            }
            String[] rules = splitGrammar[1].split("\\|");
            // rearrange the format of each rule and store each element in
            //     each rule into an array
            String[][] wellFormattedRule = new String[rules.length][];
            for (int i = 0; i < wellFormattedRule.length; i++) {
                wellFormattedRule[i] = rules[i].trim().split("\\s+");
            }
            grammarMap.put(nonterminal, wellFormattedRule);
        }
    }

    // post: Returns true if the given symbol (case-sensitive) is a nonterminal
    //       of the grammar; returns false otherwise
    public boolean grammarContains(String symbol) {
        return grammarMap.containsKey(symbol);
    }

    // pre: the grammar contains the given nonterminal symbol (case-sensitive),
    //      and times >= 0 (throw an IllegalArgumentException if either is not
    //      satisfied)
    // post: Randomly generate the given number of occurrences of the given
    //       symbol, using the grammar. Each result of the given symbol has
    //       one space between each two elements, without beginning or trailing
    //       spaces. Each rule of a nonterminal has the same probability to
    //       be chosen. Returns the result as an array of strings.
    public String[] generate(String symbol, int times) {
        if (!grammarMap.containsKey(symbol) || times < 0) {
            throw new IllegalArgumentException();
        }
        String[] result = new String[times];
        for (int i = 0; i < times; i++) {
            result[i] = generate(symbol).substring(1);
        }
        return result;
    }

    // post: Randomly (each rule has the same probability) generates the given
    //       symbol, using the grammar, and returns the result. The result has
    //       only one space between each two elements and has no beginning and
    //       trailing spaces.
    private String generate(String symbol) {
        if (!grammarMap.containsKey(symbol)) {
            return " " + symbol;
        } else {
            String[][] rules = grammarMap.get(symbol);
            int indexOfRule = (int) (Math.random() * rules.length);
            String result = "";
            for (String currentSymbol : rules[indexOfRule]) {
                result += generate(currentSymbol);
            }
            return result;
        }
    }

    // post: returns a string representation of the nontermianl symbols from
    //       the grammar in the form of a sorted, comma-separated list enclosed
    //       in square brackets.
    public String getSymbols() {
        return grammarMap.keySet().toString();
    }
}