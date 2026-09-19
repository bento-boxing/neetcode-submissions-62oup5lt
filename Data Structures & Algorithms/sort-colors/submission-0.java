class Solution {
    public void sortColors(int[] nums) {
        int[] colorFreq = new int[3];
        for (int i : nums) {
            switch (i) {
                case 0 -> colorFreq[0]++;
                case 1 -> colorFreq[1]++;
                case 2 -> colorFreq[2]++;
            }
        }

        int currentPosition = 0;
        for (int color = 0; color < 3; color++) {
            for (int i = 0; i < colorFreq[color]; i++) {
                nums[currentPosition] = color;
                currentPosition++;
            }
        }
    }
}