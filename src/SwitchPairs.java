import java.util.ArrayList;

public class SwitchPairs {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("four");
        list.add("score");
        list.add("and");
        list.add("seven");
        list.add("years");
        list.add("ago");
        list.add("away");
        System.out.println("before: " + list);
        switchPairs(list);
        System.out.println("after: " + list);
    }

    public static void switchPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i + 1);
            list.set(i + 1, list.get(i));
            list.set(i, temp);
        }
    }
}
