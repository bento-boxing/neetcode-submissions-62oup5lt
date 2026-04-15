class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] squares = new int[9];

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;

                // convert the value stored in this cell into ASCII
                int val = board[r][c] - '1';

                /*
                Each integer in each array stores the data for its row/column/square. Each bit in the integer
                represents the numbers that have been seen so far.

                The first rows[r] would find 0's bits, we are only interested in last 9: i.e. 000000000
                then if the first value is 1, we get a val of 0, so we add 1 to the val-th bit, 000000001,
                and compare this with the original: 000000000 & 000000001 = 000000000

                Consider now if we had a 5 in row 0, we look at rows[0], which returns 000000001, and now we
                shift a 1 4 places to the left: 000010000 & 00000001 = 000000000. Notice that this would only
                ever return > 0 if we had the same number appearing twice.

                For the squares; each integer in the array represents a separate square, we number the 
                squares on the sudoku board from top left to bottom left 0 1 2. We need to do (r / 3) * 3
                because we want to truncate the row first - i.e. so that the first 3 rows go to 0 1 2 
                in the squares array. Otherwise, [0][0] goes to squares[0], but [1][0] goes to squares[1], 
                despite them being within the same square!
                */

                if((rows[r] & (1 << val)) > 0 || (columns[c] & (1 << val)) > 0 ||
                (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
                    return false;
                }

                /*
                Here we need to use the OR bitwise operator, to add the current flag into the 
                bits of the integer.
                */
                rows[r] |= (1 << val);
                columns[c] |= (1 << val);
                squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
            }
        }

        return true;
    }
}
