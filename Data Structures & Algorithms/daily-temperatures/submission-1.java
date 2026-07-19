class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(temperatures[i] > temperatures[j]) {
                    res[j] = i - j;
                }
            }
        }

        return res;
    }
}
