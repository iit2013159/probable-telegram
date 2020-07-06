package leetcode;

public class RemoveFromNthEndLinkList {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        ListNode current = head;
        for(int i = 0; i < n;i++){
            ahead = ahead.next;
        }
        while(ahead != null){
            ahead = ahead.next;
            current = current.next;
        }
        if(current.next != null){
            ListNode next = current.next;
            ahead.next = next.next;
        }
        return head;
    }
}
