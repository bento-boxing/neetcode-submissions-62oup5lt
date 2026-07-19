class Solution {
    private static final Map<String, java.util.function.IntBinaryOperator> OPERATIONS = Map.of(
        "+", (left, right) -> left + right,
        "-", (left, right) -> left - right,
        "/", (left, right) -> left / right,
        "*", (left, right) -> left * right
    );

    public int evalRPN(String[] tokens) {
        Deque<Integer> calc = new ArrayDeque<>();
        for(String token : tokens) {
            if(OPERATIONS.containsKey(token)) {
                int right = calc.pop();
                int left = calc.pop();

                int result = OPERATIONS.get(token).applyAsInt(left, right);
                calc.push(result);
            } else {
                calc.push(Integer.parseInt(token));
            }
        }

        return calc.pop();
    }
}
