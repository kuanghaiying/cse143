public class ListNodeClient {
   public static void main(String[] args) {
      ListNode q = new ListNode(3, new ListNode(4, new ListNode(5)));
      ListNode p = new ListNode(1, new ListNode(2));
      p.next.next = q;
      q = q.next.next;
      q.next = p;
      p.next.next.next.next = p.next;
      p = p.next.next.next;
      q.next.next = null;
      p.next.next.next = null;
   }
}