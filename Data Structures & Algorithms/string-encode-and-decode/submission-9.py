class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ''
        for s in strs:
            res += s + '¥'
        return res

    def decode(self, s: str) -> List[str]:
        word = ''
        res = []
        for char in s:
            if char != '¥':
                word += char
            else:
                res.append(word)
                word = ''
        return res
