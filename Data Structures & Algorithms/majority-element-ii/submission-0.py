class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        number_of_times = math.floor(len(nums) / 3)
        counter = Counter(nums)
        # return keys where their values are greater than number_of_times
        return [key for (key, value) in counter.items() if value > number_of_times]