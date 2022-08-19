// Simple, brute force solution [O(N^2)], works with small test cases
// but times out on larger cases

class Solution {
    public int maxArea(int[] height) {
        
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if ((j - i) * Math.min(height[i], height[j]) > max_area) {
                    max_area = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return max_area;
    }
}
