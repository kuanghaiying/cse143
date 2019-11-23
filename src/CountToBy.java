public class CountToBy {
    public static void main(String[] args) {
        countToBy(25, 4);
    }

    public static void countToBy(int by, int interval) {
        if (interval >= by) {
            System.out.print(by);
        } else {
            countToBy(by - interval, interval);
            System.out.print(", " + by);
        }
    }
}
