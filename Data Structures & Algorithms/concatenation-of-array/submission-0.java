class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = Arrays.copyOf(nums, 2 * nums.length);
        
        for(int i = 0; i < nums.length; i++) {
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }
}