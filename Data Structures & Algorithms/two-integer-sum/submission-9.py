class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # value -> index
        seenMap: Map[int, int] = {}
        for index, num in enumerate(nums):
            target_num: int = target - num
            if target_num in seenMap:
                return [seenMap[target_num], index]
            seenMap[num] = index