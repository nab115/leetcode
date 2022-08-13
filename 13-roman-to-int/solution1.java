import java.util.*;

class Solution {
    public int romanToInt(String s) {
    
        Hashtable<String,Integer> tbl = new Hashtable<String,Integer>();
        
        tbl.put("I", 1);
        tbl.put("IV", 4);
        tbl.put("V", 5);
        tbl.put("IX", 9);
        tbl.put("X", 10);
        tbl.put("XL", 40);
        tbl.put("L", 50);
        tbl.put("XC", 90);
        tbl.put("C", 100);
        tbl.put("CD", 400);
        tbl.put("D", 500);
        tbl.put("CM", 900);
        tbl.put("M", 1000);
        
        int i = 0;
        int sum = 0;
        String rn = s;
        
        while (i < rn.length()) {
            
            if (
                i < rn.length() - 1
                && tbl.containsKey("" + rn.charAt(i) + rn.charAt(i + 1))
            ) {
                sum += tbl.get("" + rn.charAt(i) + rn.charAt(i + 1));
                i = i + 2;
            }
            
            else {
                sum += tbl.get("" + rn.charAt(i));
                i++;
            }
            
        }
        return sum;
    }
}