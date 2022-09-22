import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        
        int [] rowOrder = new int[s.length()];
        Hashtable<Integer, StringBuilder> parts = new Hashtable<Integer, StringBuilder>();
        
        // create stringbuilder for each row
        for (int i = 1; i <= numRows; i++) {
            parts.put(i, new StringBuilder());
        }
        
        // add characters to respective rows
        int direction = 1;
        for (int i = 0, r = 1; i < s.length(); i++) {
            
            parts.get(r).append(s.charAt(i));
            r = r + (1 * direction);
            
            // if we hit the min or max row, change direction
            if(r == numRows | r == 1) {
                direction = direction * -1;
            }
        }
        
        String answer = "";
        // concat each row
        for (int i = 1; i <= numRows; i++) {
            answer = answer + parts.get(i).toString();
        }
        
        return answer;
    }
}