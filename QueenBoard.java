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
    return solveH(0);
  }

  public boolean solveH(int c) {
    if (c == board.length) {
      //Queens have been added to all cols
      return true;
    }
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r,c)) {
        //If queen can be added, method tests next column
        //If not, queen is removed and the square below is checked
        if (solveH(c + 1)) {
          return true;
        }
        removeQueen(r,c);
      }
    }
    return false;
  }

  public int countSolutions() {
    return countH(0);
  }

  public int countH(int c) {
    int total = 0;
    if (c == board.length) {
      return 1;
    }
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r,c)) {
        total = total + countH(c + 1);
        removeQueen(r,c);
      }
    }
    return total;
  }
}
