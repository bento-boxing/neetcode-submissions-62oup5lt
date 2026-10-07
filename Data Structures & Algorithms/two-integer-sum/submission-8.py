class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        counter = Counter(nums)
        for index, num in enumerate(nums):
            target_num = target - num
            if target_num == num and counter[num] > 1:
                return [index, nums.index(target_num, index +1)]
            elif target_num != num and target_num in counter:
                return [index, nums.index(target_num)]

        return [-1, -1]