class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        nums_set = set(nums)
        res = 1

        for num in nums_set:
            prev_num = num - 1
            if prev_num in nums_set:
                continue
            
            current_max = 1
            next_num = num + 1
            while next_num in nums_set:
                next_num += 1
                current_max += 1
            
            if current_max > res:
                res = current_max

        return res
            

