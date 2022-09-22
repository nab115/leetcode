class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        return lengthOfLIS(seq, nums, 0);
    }
    public int lengthOfLIS(ArrayList<Integer> seq, int[] nums, int index) {
        // if previous call checked last element in nums, return
        if(index == nums.length) {
            return seq.size();
        }
        
        // if we are considering the first element of nums, or the next element
        // to consider is greater than the last element of the current sequence
        // check both adding it to seq and skipping it
        ArrayList<Integer> seq1 = deep_copy(seq);
        seq1.add(nums[index]);
        ArrayList<Integer> seq2 = deep_copy(seq);
        if(seq.size() == 0 || (nums[index] > seq.get(seq.size() - 1))) {
            return Math.max(
                lengthOfLIS(seq1, nums, index + 1)
                , lengthOfLIS(seq2, nums, index + 1)
            );
        }
        // if next element to consider is not greater than seqences last element
        // it cannot be part of this sequence, so skip it
        return lengthOfLIS(seq2, nums, index + 1);
    }
    
    public ArrayList<Integer> deep_copy(ArrayList<Integer> a) {
        
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (Integer element : a) {
            copy.add(element);
        }
        return copy;
    }
}