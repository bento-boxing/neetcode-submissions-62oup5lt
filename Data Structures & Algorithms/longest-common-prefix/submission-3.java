class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; i < strs[0].length(); i++) {
            char letter = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != letter) {
                    return strs[j].substring(0, i);
                }
            }
        }

        // This case can only be reached if all of the strings in the array are the same
        return strs[0];
    }
}