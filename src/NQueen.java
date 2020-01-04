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

    // print board
    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // Method checks if given queen position is valid by checking previous rows and diagonals
    // col = x; row = y
    private static boolean isValid(int row, int col) {
        int i, j;

        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // upper diagonal
        for (i = row, j = col; i >= 0  && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // lower diagonal
        for (i = row,  j = col; j >=0 && i < n; j--, i++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean NQueen(int col) {
        if (col == n) {
           // printBoard();
            return true;
        }

        // Checks if given move is valid for all positions in the column
        for (int i = 0; i < n; i++) {
            if (isValid(i,col)) {
                board[i][col] = 1;

                // This creates a "temporary board state". It checks to see if the next column has a valid position at all
                // If there is no valid position, it goes back to the previous board state, and makes the Queen's position
                // a 0. Then it goes to the next valid position for that board state.
                if (NQueen(col+1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }

        // if it leaves this forloop recurse
        return false;
    }


    public static void main(String[] args) {
        if (NQueen(0)) {
            printBoard();
        }
/*     board[2][1] = 1;
       printBoard();
       System.out.println(isValid(3,2));*/

        //System.out.println(isValid(0,0));
    }

}
