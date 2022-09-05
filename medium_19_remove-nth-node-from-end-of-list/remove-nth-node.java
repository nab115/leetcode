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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head_ = head;
        ListNode tail = head;
        int i = 0;
        
        // edge case if list has just 1 node, we remove the node and return null
        if (head_.next == null) {
            return null;
        }
        
        while (tail != null) {
            
            tail = tail.next;
            
            // want to position head n + 1 nodes away from tail
            if (i > n) {
                head_ = head_.next;
            }
            i++;
        }
        
        // we have reached the end of the list
        
        // if we went through n iterations, that means we need to remove the first node in the list
        if (i == n) {
            return head.next;
        }

        // otherwise head is the node before the node we need to remove, so we just skip the next node
        head_.next = head_.next.next;
        return head;
    }
}