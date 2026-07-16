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
        String res = "";
        for (int r = t.length(); r < s.length(); r++) {
            sCounts[s.charAt(r) - 'A']++;

            while (isSubset(tCounts, sCounts)) {
                if(res.length() == 0 || r - l + 1 < res.length()) {
                    res = s.substring(l, r) + s.charAt(r);
                }
            
                sCounts[s.charAt(l) - 'A']--;
                l++;
            }
        }

        return res;
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
