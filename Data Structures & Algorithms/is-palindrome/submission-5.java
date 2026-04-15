class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(cleanedString.isEmpty()) {
            return true;
        }

        int l = 0, r = cleanedString.length() - 1;

        while(l < r) {
            if(cleanedString.charAt(l) != cleanedString.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
