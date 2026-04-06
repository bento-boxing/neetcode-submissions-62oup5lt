class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) {
            return null;
        }

        int[] returnArray = new int[2];
        
        for(int i = 0; i < nums.length - 1; i++) {
            returnArray[0] = i;

            for(int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    returnArray[1] = j;
                    return returnArray;
                }
            }
        }

        return null;
    }
}
