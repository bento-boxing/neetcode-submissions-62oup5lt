class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int numberOfZeroes = 0;
        int zeroIndex = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numberOfZeroes++;
                zeroIndex = i;
            } else {
                total = total * nums[i];
            }
        }

        int[] res = new int[nums.length];

        if(numberOfZeroes == 1) {
            res[zeroIndex] = total;
            
        } else if (numberOfZeroes == 0 ) {
            for(int i = 0; i < nums.length; i++) {
                res[i] = total / nums[i];
            }
        }

        return res;
    }
}  
