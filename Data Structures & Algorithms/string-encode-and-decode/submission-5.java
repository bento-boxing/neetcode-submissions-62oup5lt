class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> returnList = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {
            int delimiterIndex = str.indexOf("#", i);

            String lengthOfTextAsString = str.substring(i, delimiterIndex);
            i = i + lengthOfTextAsString.length();

            int lengthOfText = Integer.parseInt(lengthOfTextAsString);
            returnList.add(str.substring(delimiterIndex + 1, delimiterIndex + 1 + lengthOfText));

            i = i + 1 + lengthOfText;
        }

        return returnList;
    }
}
