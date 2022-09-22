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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode();
        ListNode current = head;
        ListNode zero = new ListNode(0);
        zero.next = zero;
        int digit;
        int d1;
        int d2;
        
        // if at least one of the lists still has nodes, or there is a carry, continue
        while(l1 != zero || l2 != zero || carry) {
            
            // perform basic arithmetic - sum each aligned digit, 
            // add 1 if there is a carry from previous sum
            digit = l1.val + l2.val;
            if (carry) {
                digit = digit + 1;
                carry = false;
            }

            current.val = digit % 10;

            // carry over for next
            if (digit >= 10) {
                carry = true;
            }

            // continue to next node in each list. Note that if one list has reached its end, it will be assigned
            // to the zero node which loops back upon itself
            l1 = l1.next;
            l2 = l2.next;
            
            // if we have reached the end of either list, set that node to the zero node
            if(l1 == null) {
                l1 = zero;
            }
            if (l2 == null) {
                l2 = zero;
            }
            if (l1 != zero || l2 != zero || carry) {
                current.next = new ListNode();
                current = current.next;
            }
        }
              
        return head;
    }
}