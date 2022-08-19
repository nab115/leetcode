class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        ListNode curr = head;
        do {
            list.add(curr.val);
            curr = curr.next;
        }
        while (curr != null);
        
        for(int i = 0; i <= (list.size()/2) - 1; i++) {
            if(list.get(i) != list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}