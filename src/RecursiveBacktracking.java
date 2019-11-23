public class RecursiveBacktracking {
    public static final String[] CHARACTER = {"A", "B", "C", "D", "E", "F", "G"};

    public static void main(String[] args) {
        printABC();
    }

    public static void printABC() {
        printABC("");
    }

    public static void printABC(String soFar) {
        if (soFar.length() == 10) {
            // System.out.println(soFar);

        } else {
            for (String character : CHARACTER) {
                printABC(soFar + character);
            }
        }
    }
}
