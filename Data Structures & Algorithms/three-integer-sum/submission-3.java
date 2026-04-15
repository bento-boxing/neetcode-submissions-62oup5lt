class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // [-2, 0, 0, 2, 2]
            //   i  l        r
            // sum = 0

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    Integer[] newResult = new Integer[] {nums[i], nums[l], nums[r]};
                    res.add(Arrays.asList(newResult));

                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }

            // What causes the repeat? 1, 3, 4 and 2, 3, 4 because 1 = 2 in [-4, -1, -1, 0, 1, 2]
        }
        
        return res;
    }
}