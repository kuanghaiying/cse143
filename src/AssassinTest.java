import java.util.ArrayList;
import java.util.List;

public class AssassinTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Tyler");
        names.add("Charlie");
        names.add("Graham");

        AssassinManager game = new AssassinManager(names);
        game.printKillRing();
        game.kill("Graham");
        System.out.println("After:");
        game.printKillRing();
        System.out.println();
        game.printGraveyard();
    }
}
