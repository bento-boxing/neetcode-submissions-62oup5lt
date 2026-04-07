class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFrequencies = new HashMap<>();

        // The maximum frequency is the length of the nums array.
        List<Integer>[] bucketSort = new List[nums.length + 1];

        // Initialise the bucket sort array lists
        for(int i = 0; i < bucketSort.length; i++) {
            bucketSort[i] = new ArrayList<>();
        }

        for(int num : nums) {
            numberFrequencies.put(num, numberFrequencies.getOrDefault(num, 0) + 1);
        }

        // Put the number at the index of its frequency
        for(Map.Entry<Integer, Integer> entry : numberFrequencies.entrySet()) {
            bucketSort[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int numberOfCollectedInts = 0;

        for(int i = bucketSort.length - 1; i > 0 && numberOfCollectedInts < k; i--) {
            // iterate through each arraylist in the list of frequencies 
            for(int n : bucketSort[i]) {
                // this works because the variable is incremented AFTER the assignment is done, so this would first assign to 0
                result[numberOfCollectedInts++] = n;
                if(numberOfCollectedInts == k) {
                    return result;
                }
            }
        }
        
        // notice in this implementation we only had to iterate through the nums once, our frequency list once, the entries once
        // and the buckesort list once. This means that we are operating under O(n)!
        return result;
    }
}
