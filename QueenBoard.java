public class QueenBoard {
  //2D int array that stores the number of queens that attack each square, or -1 for a queen
  private int[][] board;

  //Constructor
  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public String toString() {
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) {
          ans += "Q ";
        } else {
          ans = ans + board[i][j] + " ";
        }
      }
      ans += '\n';
    }
    return ans;
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      //Adds 1 to all squares on the row to the right
      for (int i = c + 1; i < board.length; i++) {
        board[r][i]++;
      }
      int i = 1;
      //Adds 1 to all squares on the diagonal down and right
      while (r + i < board.length && c + i < board[r].length) {
        board[r + i][c + i]++;
        i++;
      }
      i = 1;
      //Adds 1 to all squares on the diagonal up and right
      while (r - i >= 0 && c + i < board[r].length) {
        board[r - i][c + i]++;
        i++;
      }
      return true;
    }
    return false;
  }

  public boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int i = c + 1; i < board.length; i++) {
        board[r][i]--;
      }
      int i = 1;
      while (r + i < board.length && c + i < board[r].length) {
        board[r + i][c + i]--;
        i++;
      }
      i = 1;
      while (r - i >= 0 && c + i < board[r].length) {
        board[r - i][c + i]--;
        i++;
      }
      return true;
    }
    return false;
  }

  /*
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve() {
    int[] rows = new int[board.length];
    return solveH(0,0, rows);
  }

  public boolean solveH(int r, int c, int[] rows) {
    if (c == board.length) {
      //Queens have been added to all cols
      return true;
    } else {
      if (addQueen(r,c)) {
        //If queen can be added, move on to next col
        rows[c] = r;
        return solveH(0, c + 1, rows);
      } else {
        if (r == board.length - 1) {
          if (c == 0) {
            return false;
          }
          //Backtracking
          c--;
          while (rows[c] == board.length - 1) {
            removeQueen(rows[c], c);
            c--;
          }
          removeQueen(rows[c], c);
          return solveH(rows[c] + 1, c, rows);
        } else {
          return solveH(r + 1, c, rows);
        }
      }
    }
  }
}
