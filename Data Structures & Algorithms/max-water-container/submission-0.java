class Solution {
    public int maxArea(int[] heights) {
        int biggestArea = 0;

        for(int i = 0; i < heights.length; i++) {
            for(int j = i + 1; j < heights.length; j++) {
                int area = (j - i) * Math.min(heights[i], heights[j]);
                if(area > biggestArea) biggestArea = area;
            }
        }
        
        return biggestArea;
    }
}
