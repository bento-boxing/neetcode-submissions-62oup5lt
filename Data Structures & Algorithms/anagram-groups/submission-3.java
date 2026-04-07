// Improved
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            // This prevents us from causing NPE in the following line
            map.putIfAbsent(sortedString, new ArrayList<>());

            // In your previous solution you had to find the string again through the index because you didn't use enhanced for.
            map.get(sortedString).add(s);
        }

        // The values are the lists of strings that have the same sorted Strings. Hence we can return the array list of ALL values
        return new ArrayList<>(map.values());
    }
}
