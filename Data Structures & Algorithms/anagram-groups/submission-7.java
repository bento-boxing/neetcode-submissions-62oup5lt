class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Array represents the frequency map of each string, the arraylist is the list of strings.
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] freqArray = new int[26];
            for(char chr : str.toCharArray()) {
                freqArray[chr - 'a'] ++;
            }
            String key = Arrays.toString(freqArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
