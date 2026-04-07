// Optimal Solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> characterFrequencyMap = new HashMap<>();

        for(String str : strs) {
            int[] characterFrequencyArray = new int[26];

            for(char ch : str.toCharArray()) {
                // c - 'a' works because we convert the character to its ASCII value, and subtract it from a, giving
                // us the letter of the alphabet this is, starting from 0, aligning with the array. Then we increment this value.
                // NEED the toLowerCase(), because the ASCII values are case sensitive, i.e. 'A' != 'a'
                characterFrequencyArray[Character.toLowerCase(ch) - 'a']++;
            }

            // Change the array of frequencies to a string.
            String key = Arrays.toString(characterFrequencyArray);
            characterFrequencyMap.putIfAbsent(key, new ArrayList<>());

            // Two strings with the same array of frequencies must be anagrams of each other.
            characterFrequencyMap.get(key).add(str);
        }

        return new ArrayList<>(characterFrequencyMap.values());
    }
}
