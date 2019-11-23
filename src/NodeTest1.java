public class NodeTest1 {
    public static void main(String[] args) {
        // ListNode front = null;
//         for (int i = 0; i <= 10; i++) {
//             front = new ListNode(i, front);
//         }
//         ListNode current = front;
//         for (int i = 0; i < 5; i++) {
//             current = current.next;
//             
//         }
//         current.next = new ListNode(3);
        ListNode front = null;
        front = new ListNode(0, front);
        
        
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
}