class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> digits = new HashSet<>();

        // Check the columns
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                int num = board[row][column] - '0';

                if (digits.contains(num)) {
                    return false;
                } else {
                    digits.add(num);
                }
            }

            digits.clear();
        }

        // Check the rows.
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (board[row][column] == '.') {
                    continue;
                }

                int num = board[row][column] - '0';

                if (digits.contains(num)) {
                    return false;
                } else {
                    digits.add(num);
                }
            }

            digits.clear();
        }

        // Check each square
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 9; i += 3) {
                for (int column = j; column < 3 + j; column++) {
                    for (int row = i; row < 3 + i; row++) {
                        if (board[row][column] == '.') {
                            continue;
                        }

                        int num = board[row][column] - '0';

                        if (digits.contains(num)) {
                            return false;
                        } else {
                            digits.add(num);
                        }
                    }
                }

                digits.clear();
            }
        }

        return true;
    }
}
