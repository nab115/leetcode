class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0;
        
        for (int i = 0, left = 0, right = height.length-1; i < height.length; i++) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            
            if(height[left] >= height[right]) {
                right--;
            }
            else {
                left++;
            }
        }
                
        return maxArea;
    }
}