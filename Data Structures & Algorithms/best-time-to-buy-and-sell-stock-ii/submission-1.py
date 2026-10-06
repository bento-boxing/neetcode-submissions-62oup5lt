class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        holding = -prices[0]
        not_holding = 0

        for i in range(1, len(prices)):
            not_holding = max(not_holding, holding + prices[i])
            holding = max(holding, not_holding - prices[i])

        return not_holding