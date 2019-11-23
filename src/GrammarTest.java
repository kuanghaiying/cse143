import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrammarTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictGrammar.txt"));
        List<String> grammarList = new ArrayList<>();
        while (input.hasNextLine()) {
            grammarList.add(input.nextLine());
        }
        GrammarSolver solver = new GrammarSolver(grammarList);
        System.out.println(solver.grammarMap.keySet());
    }
}
