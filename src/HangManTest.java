import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangManTest {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner input = new Scanner(new File("dictionary.txt"));
        while (input.hasNext()) {
            words.add(input.next());
        }

        HangmanManager game = new HangmanManager(words, 4, 20);
        System.out.println(game.words());
        System.out.println(game.words().size());
    }
}
