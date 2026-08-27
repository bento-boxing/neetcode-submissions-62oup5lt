class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int votes = 0;

        for(int num : nums) {
            if(votes == 0) {
                count = num;
                votes = 1;
            } else if (num == count) {
                votes ++;
            } else {
                votes --;
            }
        }

        return count;
    }
}