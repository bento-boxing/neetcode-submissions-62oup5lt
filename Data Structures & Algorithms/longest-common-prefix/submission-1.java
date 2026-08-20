class Solution {
    public String longestCommonPrefix(String[] strs) {
        String initial = strs[0];
        String result = "";

        for(int i = 0; i < initial.length(); i++) {
            String substr = initial.substring(0, i + 1);

            for(int j = 1; j < strs.length; j++) {
                try {
                    if(!substr.equals(strs[j].substring(0, i + 1))) {
                        return result;        
                    }
                } catch(IndexOutOfBoundsException e) {
                    return result;
                }
            }

            result = substr;
        }

        return result;
    }
}