class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        int res = position.length;

        for(int i = 0; i < position.length; i++) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }

        Arrays.sort(cars, Comparator.comparingDouble(row -> row[0]));
        for(int i = position.length - 1; i >=1; i--) {
            int j = i - 1;

            if(cars[i][1] >= cars[j][1]) {
                // replace exactly NOT add because they would arrive at the same time after catching up.
                cars[j][1] = cars[i][1];
                res--;
            }
        }

        return res;
    }
}
