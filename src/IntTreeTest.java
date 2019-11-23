import java.util.*;
import java.io.*;

public class IntTreeTest {
    public static void main(String[] args) throws FileNotFoundException {
        IntTree tree1 = new IntTree();
        IntTree tree2 = new IntTree();
        Scanner input = new Scanner(new File("TreeFile.txt"));
        tree1.readTree(input);
        tree1.printSideWay();
        tree1.swapChildrenAtLevel(2);
        System.out.println("-------------------------------");
        tree1.printSideWay();
    }
}
