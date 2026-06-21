/  
   Definition for singly-linked list.
   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
  /
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode prev = null;  

        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            l1.val = (temp < 10) ? temp : temp - 10;
            carry = (temp < 10) ? 0 : 1;
            prev = l1;         
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int temp = l1.val + carry;
            l1.val = (temp < 10) ? temp : temp - 10;
            carry = (temp < 10) ? 0 : 1;
            prev = l1;        
            l1 = l1.next;
        }

        while (l2 != null) {
            prev.next = new ListNode();
            prev = prev.next;

            int temp = l2.val + carry;
            prev.val = (temp < 10) ? temp : temp - 10;
            carry = (temp < 10) ? 0 : 1;

            l2 = l2.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);  
        }
        return head;
    }
}