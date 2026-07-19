class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int n = temperatures.length;

        for(int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while(j < n && temperatures[j] <= temperatures[i]) {
                if(res[j] == 0) {
                    j = n;
                    break;
                }
                j += res[j];
            }

            if(j < n) {
                res[i] = j - i;
            }
        }

        return res;
    }
}
