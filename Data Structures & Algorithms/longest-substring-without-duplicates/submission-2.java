class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> previousCharacters = new HashSet<>();

        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++) {
            while(previousCharacters.contains(s.charAt(r))) {
                previousCharacters.remove(s.charAt(l));
                l++;
            }

            previousCharacters.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
