class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] sCounts = new int[58];
        int[] tCounts = new int[58];

        for (int i = 0; i < t.length(); i++) {
            sCounts[s.charAt(i) - 'A']++;
            tCounts[t.charAt(i) - 'A']++;
        }

        if (Arrays.equals(sCounts, tCounts)) {
            return s.substring(0, t.length());
        }

        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        for (int r = t.length(); r < s.length(); r++) {
            sCounts[s.charAt(r) - 'A']++;

            while (isSubset(tCounts, sCounts)) {
                int currentWindowLength = r - l + 1;

                if(currentWindowLength < minLength) {
                    minLeft = l;
                    minLength = currentWindowLength;
                }

                sCounts[s.charAt(l) - 'A']--;
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    private boolean isSubset(int[] subarray, int[] original) {
        if (original.length != subarray.length || original.length == 0) {
            return false;
        }

        for (int i = 0; i < original.length; i++) {
            if (subarray[i] > original[i]) {
                return false;
            }
        }

        return true;
    }
}
