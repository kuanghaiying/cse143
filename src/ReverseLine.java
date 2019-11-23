import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseLine {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("reverseLine.txt"));
        printReverse(input);
    }

    public static void printReverse(Scanner input) {
        if (input.hasNextLine()) {
            String line  = input.nextLine();
            printReverse(input);
            System.out.println(line);
        }
    }
}
