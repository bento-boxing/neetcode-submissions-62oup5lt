class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(Character c : s.toCharArray()) {
            switch(c) {
                case '(' -> deque.push(')');
                case '[' -> deque.push(']');
                case '{' -> deque.push('}');
                case ')' -> {
                    if(deque.size() == 0 || deque.pop() != ')') return false;
                }
                case ']' -> {
                    if(deque.size() == 0 || deque.pop() != ']') return false;
                }
                case '}' -> {
                    if(deque.size() == 0 || deque.pop() != '}') return false;
                }
                default -> {return false;}
            }
        }

        return deque.size() == 0;
    }
}
