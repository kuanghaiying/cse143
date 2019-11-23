import java.io.*;
import java.util.*;

public class Reverse {
    public static void main(String[] args) throws FileNotFoundException {

    }

    public static void reverse(Scanner input) {
        if (input.hasNextLine()) {
            String currentLine = input.nextLine();
            reverse(input);
            System.out.println(currentLine);
        }
    }
}
