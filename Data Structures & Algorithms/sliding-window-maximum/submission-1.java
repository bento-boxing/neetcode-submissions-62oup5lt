class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) {
            return null;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = l + k;

        for(int i = 0; i < k; i++) {
            heap.add(new int[] {nums[i], i});
        }

        for(int i = 0; i < res.length; i++) {
            while(heap.peek()[1] < i) {
                heap.poll();
            }

            res[i] = heap.peek()[0];
            if(r < nums.length) {
                heap.add(new int[] {nums[r], r});
                r++;
            }
        }

        return res;
    }
}
