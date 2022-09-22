class Solution {
    public int lengthOfLIS(int[] nums) {
        // store max length of subseq. ending with element at nums[i]
        int[] sizes = new int[nums.length];
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            // for each element in nums, find maximum sized subsequence
            // ending at some point prior in the array, who's last element
            // is less than the current element
            int max_length = 0;
            for(int j = 0; j <= i; j++) {
                if ((nums[j] < nums[i]) && (sizes[j] > max_length)) {
                    max_length = sizes[j];
                }
            }

            // the max length subsq. at index i is max_length + 1 (current element)
            sizes[i] = max_length + 1;

            // determine longest length so far
            if (max_length + 1 > result) {
                result = max_length + 1;
            }
        }
        
        return result;
    }
}