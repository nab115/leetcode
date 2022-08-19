/*
To solve with O(1) space we cannot store the linked list as an array
This solution attempts to store node values as an integer with each node
contributing its value X 10^(distance away from the midpoint). 
Values before the midpoint are added, those after are subtracted

This relys on the assumption that for a(x^n) + b(x^(n-1)) + ... + c = f + ... + e(x^(n-1)) + d(x^n)
to be true, a = d, b = e, c = f must also be true

The issue with this approach is it doesnt account for very long linked lists which surpass the
size of Integer (-2147483648 to 2147483647), so it  failed for test case 

[8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8]
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        // determine size of list, needed for determining midpoint
        ListNode curr = head;
        int size = 0;
        do {
            size++;
            curr = curr.next;
        } while (curr != null);
        
        int i = 0;
        int sum = 0;
        // midpoint will be index of the midpoint node
        // if there are 5 nodes the 3rd node (i = 2) is the middle
        // if there are 4 nodes the midpoint is 1.5 between i = 1 and i = 2
        double midpoint = (size - 1) / 2.0;
        curr = head;
        
        do {
            // must be number of nodes odd for midpoint to be an integer
            // skip middle element of odd numbered list
            if(i == midpoint) {

            }
            // truncate the .5 if even number of nodes
            else if (i < midpoint) {
                sum += curr.val * Math.pow(10, Math.floor(midpoint - i));
            }
            else {
                sum -= curr.val * Math.pow(10, Math.floor(i - midpoint));
            }
            curr = curr.next;
            i++;
        } while (curr != null);

        if (sum == 0) {
            return true;
        }
        return false; 
    }
}