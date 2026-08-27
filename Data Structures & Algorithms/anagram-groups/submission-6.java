class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Array represents the frequency map of each string, the arraylist is the list of strings.
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for(String str : strs) {
            Integer[] freqArray = new Integer[26];
            Arrays.fill(freqArray, 0);
            
            for(char chr : str.toCharArray()) {
                freqArray[chr - 'a'] ++;
            }

            ArrayList<String> currentString = new ArrayList<>();
            currentString.add(str);

            List<String> matchingStrings = map.putIfAbsent(Arrays.asList(freqArray), currentString);

            if (matchingStrings != null) {
                matchingStrings.add(str);
            }
        }

        return new ArrayList(map.values());
    }
}
