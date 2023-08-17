/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int len = 0;
        ListNode x = head;
        while (x != null) {
            x = x.next;
            len++;
        }
        int cnt = 0;

        x = head;
        while (cnt < len/2 - 1) {
            x = x.next;
            cnt++;
        }
        x.next = x.next.next;
        return head;
    }
}
