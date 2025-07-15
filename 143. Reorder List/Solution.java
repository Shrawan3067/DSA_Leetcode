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
    public void reorderList(ListNode head) {
        //check if there is 1 or 2 node
        if (head.next == null || head.next.next == null) {
            return;
        }
        //find midNode
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;

        //reverse second half
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        midNode = prev;

        //link first and second half
        curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = midNode;

        //reorder the linkedlist
        curr = head;
        next = null;
        ListNode midCurr = midNode;
        ListNode midNext;
        while (midCurr != null) {
            if (curr.next == midNode) {
                curr.next = midCurr;
                return;
            }
            next = curr.next;
            curr.next = midCurr;
            curr = next;
            midNext = midCurr.next;
            midCurr.next = curr;
            midCurr = midNext;
            
        }
    }
}