class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArrayS = new int[26];
        int[] charArrayT = new int[26];

        for ( int i = 0; i < s.length(); i++) {
            charArrayS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charArrayT[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(charArrayS, charArrayT);
    }
}
