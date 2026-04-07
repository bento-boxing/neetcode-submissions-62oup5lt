class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);

                map.put(sortedString, indices);
            }
        }

        for(List<Integer> indices : map.values()) {
            String[] strings = new String[indices.size()];

            for(int i = 0; i < indices.size(); i++) {
                int index = indices.get(i);
                strings[i] = strs[index];
            }

            resultList.add(Arrays.asList(strings));
        }

        return resultList;
    }
}
