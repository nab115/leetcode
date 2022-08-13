/* 
Improved on previous solution by including 
only roman numeral characters in hashmap.
Instead of checking if 2 character string is present,
we can just check if one character is smaller than the next.
If it is, take the difference and add it, then increment by 2
*/

import java.util.*;

class Solution {
    public int romanToInt(String s) {

        Hashtable<Character,Integer> tbl = new Hashtable<Character,Integer>();

        tbl.put('I', 1);
        tbl.put('V', 5);
        tbl.put('X', 10);
        tbl.put('L', 50);
        tbl.put('C', 100);
        tbl.put('D', 500);
        tbl.put('M', 1000);

        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            int addend = tbl.get(s.charAt(i));

            if (
                i < s.length() - 1
                && addend < tbl.get(s.charAt(i + 1))
            ) {
                addend = addend * -1;
            }
                sum += addend;
        }
        return sum;
    }
}