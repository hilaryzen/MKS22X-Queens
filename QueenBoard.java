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
      for (int i = c + 1; i < board.length; i++) {
        board[r][i]++;
      }
      int i = 1;
      while (r + i < board.length && c + i < board[r].length) {
        board[r + i][c + i]++;
        i++;
      }
      i = 1;
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
    int[] cols = new int[board.length];
    return solveH(0,0, cols);
  }

  public boolean solveH(int r, int c, int[] cols) {
    if (r == board.length) {
      //Queens have been added to all rows
      return true;
    } else {
      if (addQueen(r,c)) {
        //If queen can be added, move on to next row
        cols[r] = c;
        return solveH(r + 1, c, cols);
      } else {
        if (c == board.length - 1) {
          return false;
        } else {
          return solveH(r, c + 1, cols);
        }
      }
    }
  }
}
