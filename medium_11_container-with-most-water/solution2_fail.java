class Solution {
    public int maxArea(int[] height) {
        
        // maximum height is 10^4
        // maximum width is n - 1
        int max_area = (height.length - 1) * 10000;
        
        // iterate from max area down to 0 to check the max area in the array
        for (int a = max_area; a > 0; a--) {
            for (int i = 0; i < height.length - 1; i ++) {
                
                // if area is less than current element, 
                // the quotient is not an integer,
                // or current element is 0
                // there cannot be a matching element
                if (a < height[i] || a % height[i] != 0 || height[i] == 0) {
                    continue;
                }
                
                int q = a / height[i];
                
                if(i < height.length - q && height[i + q] >= height[i]) {
                    return a;
                }
            }
        }
        return 0;
    }
}