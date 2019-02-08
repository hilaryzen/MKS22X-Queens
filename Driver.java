public class Driver {
  public static void main(String[] args) {
    QueenBoard board = new QueenBoard(8);
    System.out.println(board);

    System.out.println(" ");

    System.out.println(board.addQueen(0,0));
    System.out.println(board.addQueen(4,0));
    System.out.println(board);
  }
}
