// this is the optimal solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) {
            return null;
        }

        // create a Hashmap with key value as value of the array and index
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            // if our map contains the number needed to be added to the current number to reach the target, we found the solution
            if(indexMap.containsKey(complement)) {
                return new int[] {indexMap.get(complement), i};
            }

            // if not, we add the current number, as it could be the complement of a future number in the array.
            indexMap.put(num, i);
        }

        // in case no solution is found
        return new int[] {};
    }
}
