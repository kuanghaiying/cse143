import java.util.ArrayList;

public class Repeat {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("how");
        list.add("are");
        list.add("you");
        System.out.println("before: " + list);
        repeat(list);
        System.out.println("after: " + list);
    }

    public static void repeat(ArrayList<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i * 2 + 1, list.get(i * 2));
        }
    }
}
