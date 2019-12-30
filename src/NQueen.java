/*
Constraint programming
1. Place queen in N col/ N row (manipulates board row/col)
    a. Check if valid move (make method for isValid)
    b. IsValid checks if current queen is on the same row/diagonal (Returns true/false)
2. If valid go to next row
3. Else check next square
    a. if reaches > N rows all moves are not valid
    b. need to delete block
    c. Go to previous row, and
 */


public class NQueen {
    // Initialized variables and board
    private static final int n = 4;
    private static int[][] board = new int[n][n];

    // Method checks if given queen position is valid by checking previous rows and diagonals
    // col = x; row = y
    private static boolean isValid(int col, int row) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // upper diagonal
        for (i = col, j = row; i >= 0  && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // lower diagonal
        for (i = col, j = row; i >=0 && j >=0; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;



    }


    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        board[0][0] = 1;
        printBoard();
    }

}
