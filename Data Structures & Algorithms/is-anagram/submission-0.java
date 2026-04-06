class Solution {
    public boolean isAnagram(String... strings) {
        if(strings == null || strings.length < 1) {
            return false;
        }
        
        int firstStringLength = strings[0].length();

        Set<String> stringSet = new HashSet<>();
        
        for(String string : strings) {
            if(string.length() != firstStringLength) {
                return false;
            }

            stringSet.add(stringSorter(string));
        }

        return stringSet.size() == 1;
    }


    private String stringSorter(String s) {
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        return new String(sCharArray);
    }
}
