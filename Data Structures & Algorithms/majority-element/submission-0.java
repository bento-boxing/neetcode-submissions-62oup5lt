class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            if (freqMap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}