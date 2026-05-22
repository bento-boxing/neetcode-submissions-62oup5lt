class Solution {
    public int characterReplacement(String s, int k) {
        // BBBAABBBAABBBB we want the longest substring of letters with at most k other letters (keep track of this through a counter)
        Map<Character, Integer> previousCharacters = new HashMap<>();

        int maxFreq = 0;
        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            previousCharacters.put(c, previousCharacters.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(previousCharacters.get(c), maxFreq);

            while((r - l + 1) - maxFreq > k) {
                previousCharacters.put(s.charAt(l), previousCharacters.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
