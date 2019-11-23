public class ListNode {
    public int data;
    public ListNode next;

    public ListNode() {
        data = 0;
        next = null;
    }
    public ListNode(int n) {
        data = n;
        next = null;
    }

    public ListNode(int n, ListNode next) {
        data = n;
        this.next = next;
    }
}
