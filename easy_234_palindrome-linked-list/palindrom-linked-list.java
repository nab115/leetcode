class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        
        // if there is only 1 node in the list it is a palindrome
        if (curr.next == null) {
            return true;
        }
        
        ListNode mid = head;
        ListNode tail = head;
        
        while (tail != null && tail.next != null) {
            tail = tail.next.next;
            mid = mid.next;
        }
        
        ListNode l1 = head;
        ListNode l2;
        
        // if tail is null there are an even # of nodes, mid will be the start of the latter half of the nodes
        if (tail == null) {
            l2 = reverseLinkedList(mid);
        }
        
        // if tail.next is null there are an odd # of nodes, mid will be the middle node which we can ignore
        // start second linked list at next node
        else {
            l2 = reverseLinkedList(mid.next);
        }
        
        printLinkedList(l1);
        printLinkedList (l2);
        
        
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
    
    // strange way to reverse the list that I came up with
    // setting the head node's "next" to null expicitly makes it so
    // you have to do pre work before the while loop which makes
    // things confusing and complicated
    public ListNode reverseLinkedList(ListNode head) {
        
        // maintain reference to next node, then make head node.next null 
        // bc it is now the end of the list
        ListNode curr = head;
        ListNode prev1 = curr.next;
        curr.next = null;
        
        if (prev1 == null) {
            return curr;
        }
        ListNode prev2 = prev1.next;
        prev1.next = curr;
        
        while (prev2 != null) {
            curr = prev1;
            prev1 = prev2;
            prev2 = prev1.next;
            prev1.next = curr;
        }
        
        return prev1;
        
    }

    // this is the classic way to reverse singly linked list
    public ListNode reverse(ListNode head) {

        // treat null as the first node so it can be handled generically in the while loop
        ListNode previous = null;
        // head cannot be null bc linked list must be at least 2 nodes long
        // since we reurn immediately if its only 1 node long
        ListNode current = head;
        // next could be null
        ListNode next = head.next;

        while (current != null) {
            current.next = previous;
            previous = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        return previous;
    }
    
    public void printLinkedList(ListNode head) {
        
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("done");
    }
}