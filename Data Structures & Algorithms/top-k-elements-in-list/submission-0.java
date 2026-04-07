class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFrequencies = new HashMap<>();

        for(int num : nums) {
            numberFrequencies.put(num, numberFrequencies.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> orderedNums = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : numberFrequencies.entrySet()) {
            orderedNums.add(entry);
        }

        Collections.sort(orderedNums, (entry1, entry2) -> -Integer.compare(entry1.getValue(), entry2.getValue()));

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = orderedNums.get(i).getKey();
        }

        return result;
    }
}
