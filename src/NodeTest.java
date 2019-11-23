public class NodeTest {
    public static void main(String[] args) {
//        ListNode list = new ListNode();
//        construct(list);
//        print(list);
//        add(list, 4);
//        print(list);
//        add(list, 3, 10);
//        print(list);
//
//        ListNode front = new ListNode(10);
//        for (int i = 9; i >= 0; i--) {
//            front = new ListNode(i, front);
//        }
//        print(front);

        ListNode list1 = null;
        for (int i = 0; i <= 10; i++) {
            list1 = new ListNode(i * 3, list1);
        }
        print(list1);
        add(list1, 0, 90);
        print(list1);
    }

    public static void construct(ListNode list) {
        list.data = 0;
        list.next = new ListNode();
        list.next.data = 1;
        list.next.next = new ListNode();
        list.next.next.data = 2;
        list.next.next.next = new ListNode();
        list.next.next.next.data = 3;
        list.next.next.next.next = null;
    }

    public static void print(ListNode list) {
        ListNode current = list;
        System.out.print("[" + list.data);
        current = current.next;
        while (current != null) {
            System.out.print(", " + current.data);
            current = current.next;
        }
        System.out.println("]");
    }
    public static void add(ListNode list, int n) {
        ListNode current = list;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode();
        current.next.data = n;
        current.next.next = null;
    }

    public static void add(ListNode list, int index, int n) {
        if (index == 0) {
            list = new ListNode(n, list);
        } else {
            ListNode current = list;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            ListNode after = current;
            current = list;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = null;
            current.next = new ListNode(n);
            current.next.next = after;
        }
    }
}

