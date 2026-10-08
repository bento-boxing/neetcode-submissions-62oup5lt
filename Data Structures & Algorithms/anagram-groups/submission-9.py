class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for string in strs:
            characters = [0] * 26
            for char in string:
                characters[ord(char) - ord('a')] += 1
            letters = ','.join([str(num) for num in characters])
            anagrams[letters].append(string)
        
        return list(anagrams.values())