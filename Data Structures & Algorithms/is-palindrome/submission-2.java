class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(cleanedString.isEmpty()) {
            return true;
        }

        Deque<Character> deque = new ArrayDeque<>();
        int middle = (cleanedString.length() - 1) / 2;

        for(int i = 0; i <= middle; i++) {
            deque.push(cleanedString.charAt(i));
        }

        if(cleanedString.length() % 2 == 1) {
            deque.pop();
        }

        for(int i = middle + 1; i < cleanedString.length(); i++) {
            if(deque.pop() == cleanedString.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
