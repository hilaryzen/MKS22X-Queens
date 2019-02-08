public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
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
}
