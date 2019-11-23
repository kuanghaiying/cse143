// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 7
// A QuestionsGame represents a tree of yes/no questions, which can be used to
//     manipulate a 20 Questions game. In such a game, players begin a round by
//     choosing some object, and and the computer attempts to guess that object
//     by asking a series of yes/no questions until it thinks it knows the
//     answer. Then, the computer makes a guess; if its guess is correct, the
//     computer wins, and otherwise the player wins. If the computer loses, it
//     will add the object the player was thinking of to its knowledge base.

import java.io.*;
import java.util.*;

public class QuestionsGame {
    private QuestionNode rootNode; // the overall root of the questions tree
    private Scanner console;

    // post: Constructs a QuestionsGame with an object called "computer" as
    //       initial questions-answers data
    public QuestionsGame() {
        rootNode = new QuestionNode("computer");
        console = new Scanner(System.in);
    }

    // pre: the file linked by the given input is legal and in standard format
    //      The file is in the form of title/content pairs, in which one line
    //      is for the title(indicate if it is a question or an answer) and the
    //      other line is for the content. The questions-answers information in
    //      the file is in pre-order.
    // post: Replaces the questions-answers tree in this QuestionsGame with the
    //       questions-answers information in the given input
    public void read(Scanner input) {
        rootNode = readHelper(input);
    }

    // pre: the file linked by the given input is legal and in standard format
    //      The file is in the form of title/content pairs, in which one line
    //      is for the title(indicate if it is a question or an answer) and the
    //      other line is for the content. The questions-answers information in
    //      the file is in pre-order.
    // post: Returns a QuestionNode which represents the new questions-answers
    //       tree read from the given input
    private QuestionNode readHelper(Scanner input) {
        String title = input.nextLine();
        QuestionNode currentNode = new QuestionNode(input.nextLine());
        if (title.equals("Q:")) {
            currentNode.yes = readHelper(input);
            currentNode.no = readHelper(input);
        }
        return currentNode;
    }

    // post: Outputs and stores the questions-answers information to the file
    //       represented by the given PrintStream. The output is in the form of
    //       title/content pairs, in which one line is for title(indicate if it
    //       is a question or an answer) and the other line is for the content.
    //       The output information is in pre-order.
    public void write(PrintStream output) {
        writeHelper(output, rootNode);
    }

    // post: Outputs the questions-answers information represented by the given
    //       currentNode to the file represented by the given PrintStream. The
    //       output is in the form of title/content pairs, in which one line is
    //       for title(indicate if it is a question or an answer) and the other
    //       line is for the content. The output information is in pre-order.
    private void writeHelper(PrintStream output, QuestionNode currentNode) {
        if (isAnswerNode(currentNode)) {
            output.println("A:");
            output.println(currentNode.text);
        } else {
            output.println("Q:");
            output.println(currentNode.text);
            writeHelper(output, currentNode.yes);
            writeHelper(output, currentNode.no);
        }
    }

    // post: Uses the questions-answers tree to play a complete guessing game
    //       with the user. It keeps asking yes/no questions until reaching an
    //       answer object to guess.
    //       If the computer wins the game, it will print a message saying so.
    //       Otherwise, it will ask the user for what is the object they were
    //       thinking of, a question to distinguish that object from the
    //       player’s guess, and whether the player’s object is the yes or no
    //       answer for that question. The questions-answers data will be
    //       updated if the computer loses.
    public void askQuestions() {
        rootNode = askQuestionsHelper(rootNode);
    }

    // post: Plays a complete game using the questions-answers tree represented
    //       by the given QuestionNode. Returns a QuestionNode which is the
    //       root of the new questions tree after completing the game and
    //       modification to the tree.
    //       (A complete game contains following steps:
    //       It keeps asking yes/no questions until reaching an answer object
    //       to guess. If the computer wins the game, it will print a message
    //       saying so. Otherwise, it will ask the user for what is the object
    //       they were thinking of, a question to distinguish that object from
    //       the player’s guess, and whether the player’s object is the yes or
    //       no answer for that question.)
    private QuestionNode askQuestionsHelper(QuestionNode currentNode) {
        if (isAnswerNode(currentNode)) {
            if (yesTo("Would your object happen to be " + currentNode.text + "?")) {
                System.out.println("Great, I got it right!");
            } else {
                System.out.print("What is the name of your object? ");
                QuestionNode answer = new QuestionNode(console.nextLine());
                System.out.println("Please give me a yes/no question that");
                System.out.println("distinguishes between your object");
                System.out.print("and mine--> ");
                String question = console.nextLine();
                if (yesTo("And what is the answer for your object?")) {
                    currentNode = new QuestionNode(question, answer, currentNode);
                } else {
                    currentNode = new QuestionNode(question, currentNode, answer);
                }
            }
        } else {
            if (yesTo(currentNode.text)) {
                currentNode.yes = askQuestionsHelper(currentNode.yes);
            } else {
                currentNode.no = askQuestionsHelper(currentNode.no);
            }
        }
        return currentNode;
    }

    // post: asks the user a question, forcing an answer of "y" or "n";
    //       returns true if the answer was yes, returns false otherwise
    public boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }

    // post: returns true if the given QuestionNode is an answer node; returns
    //       false otherwise
    private boolean isAnswerNode(QuestionNode node) {
        return node.yes == null && node.no == null;
    }

    // Represents a question node in the questions tree
    private static class QuestionNode {
        public String text;
        public QuestionNode yes;
        public QuestionNode no;

        // post: Constructs a answer node with given text
        public QuestionNode(String text) {
            this(text, null, null);
        }

        // post: Constructs a question or answer node with given text and links
        public QuestionNode(String text, QuestionNode yes, QuestionNode no) {
            this.text = text;
            this.yes = yes;
            this.no = no;
        }
    }
}