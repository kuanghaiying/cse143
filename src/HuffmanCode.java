// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 8
// This class represents a huffman code for a particular message. The huffman
//     code helps compress a message by using a new encoding method, which uses
//     shorter code to represent those more frequent characters and uses longer
//     code to represent less frequent characters. It can make a huffman code
//     using huffman coding algorithm, stores the code to an output, and
//     translate encoding of characters into original decompressed message.

import java.io.*;
import java.util.*;

public class HuffmanCode {
    private HuffmanNode overallRoot;

    // pre: Given frequencies is an array of frequencies where the value in
    //      index i of the array is the count of character with ASCII value i
    // post: Constructs a HuffmanCode using given frequencies of characters
    public HuffmanCode(int[] frequencies) {
        Queue<HuffmanNode> nodeQueue = new PriorityQueue<HuffmanNode>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                nodeQueue.add(new HuffmanNode(i, frequencies[i]));
            }
        }
        while (nodeQueue.size() > 1) {
            HuffmanNode firstNode = nodeQueue.remove();
            HuffmanNode secondNode = nodeQueue.remove();
            HuffmanNode parentNode = new HuffmanNode(firstNode.frequency + secondNode.frequency,
                                                     firstNode, secondNode);
            nodeQueue.add(parentNode);
        }
        overallRoot = nodeQueue.remove();
    }

    // pre: The given Scanner is not null and contains data encoded in legal,
    //      valid standard format. It contains information of a previously
    //      constructed code.
    // post: Constructs a HuffmanCode by reading information from the given
    //       input
    public HuffmanCode(Scanner input) {
        while (input.hasNextLine()) {
            int asciiValue = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            overallRoot = buildTree(asciiValue, code, overallRoot);
        }
    }

    // post: Adds a node which represents the given asciiValue, using the given
    //       code, into the huffman code tree represented by the given
    //       currentNode.
    private HuffmanNode buildTree(int asciiValue, String code, HuffmanNode currentNode) {
        if (code.isEmpty()) {
            return new HuffmanNode(asciiValue, 0);
        } else {
            if (currentNode == null) {
                currentNode = new HuffmanNode();
            }
            if (code.charAt(0) == '0') {
                currentNode.zero = buildTree(asciiValue, code.substring(1), currentNode.zero);
            } else {
                currentNode.one = buildTree(asciiValue, code.substring(1), currentNode.one);
            }
            return currentNode;
        }
    }

    // post: Stores the current huffman code to the given output stream. The
    //       output is in the standard format, which means it is in pairs of
    //       ASCII value of the character and the corresponding huffman code,
    //       with each one in its own line.
    public void save(PrintStream output) {
        saveHelper(output, overallRoot, "");
    }

    // post: Stores the current huffman code to the given output stream. The
    //       output is in pairs of ASCII value of the character and the
    //       corresponding huffman code, with each one in its own line.
    // parameter: currentNode ---- keeps track of the position in the tree
    //            code        ---- keeps track of the huffman code
    private void saveHelper(PrintStream output, HuffmanNode currentNode, String code) {
        if (isLeafNode(currentNode)) {
            output.println(currentNode.asciiValue);
            output.println(code);
        } else {
            saveHelper(output, currentNode.zero, code + "0");
            saveHelper(output, currentNode.one, code + "1");
        }
    }

    // pre: Given input stream contains a legal encoding of characters for this
    //      huffman code
    // post: Reads individual bits from the given input stream and write the
    //       corresponding characters to the given output
    public void translate(BitInputStream input, PrintStream output) {
        HuffmanNode currentNode = overallRoot;
        while (input.hasNextBit()) {
            if (input.nextBit() == 0) {
                currentNode = currentNode.zero;
            } else {
                currentNode = currentNode.one;
            }
            if (isLeafNode(currentNode)) {
                output.write(currentNode.asciiValue);
                currentNode = overallRoot;
            }
        }
    }

    // post: Returns true if the given node is a leaf node; otherwise returns
    //       false
    private boolean isLeafNode(HuffmanNode node) {
        return node.zero == null && node.one == null;
    }

    // Represents a huffman node in the huffman code tree. This class has a
    //     natural order.
    private static class HuffmanNode implements Comparable<HuffmanNode> {
        public int asciiValue;
        public int frequency;
        public HuffmanNode zero;
        public HuffmanNode one;
        public static final int BRANCH_DEFAULT_ASCII = -1;

        // post: Constructs a branch HuffmanNode with undetermined links
        public HuffmanNode() {
            this(0, null, null);
        }

        // post: Constructs a leaf HuffmanNode, which represents a character,
        //       with given asciiValue and frequency
        public HuffmanNode(int asciiValue, int frequency) {
            this.asciiValue = asciiValue;
            this.frequency = frequency;
        }

        // post: Constructs a branch HuffmanNode with given frequency and links
        public HuffmanNode(int frequency, HuffmanNode zero, HuffmanNode one) {
            this.asciiValue = BRANCH_DEFAULT_ASCII;
            this.frequency = frequency;
            this.zero = zero;
            this.one = one;
        }

        // post: returns a integer representing the relative order between this
        //       HuffmanNode and the other given. It returns a positive integer
        //       if the frequency of this HuffmanNode is greater than that of
        //       the other given; returns a negative integer if the frequency
        //       of this HuffmanNode is less than that of the other given;
        //       returns 0 if the frequencies of those two HuffmanNode are
        //       equal.
        public int compareTo(HuffmanNode other) {
            return this.frequency - other.frequency;
        }
    }
}
