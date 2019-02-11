public class Driver {
  public static void main(String[] args) {
    QueenBoard board = new QueenBoard(4);
    System.out.println(board);

    System.out.println(" ");

    /*
    System.out.println(board.addQueen(0,0));
    System.out.println(board.addQueen(4,0));
    System.out.println(board);

    System.out.println(" ");

    System.out.println(board.removeQueen(0,0));
    System.out.println(board.removeQueen(4,0));
    System.out.println(board);

    System.out.println(" ");

    System.out.println(board.addQueen(4,5));
    System.out.println(board);
    */

    System.out.println(board.solve());
    System.out.println(board);

    System.out.println(" ");

    QueenBoard board1 = new QueenBoard(8);
    System.out.println(board1.solve());
    System.out.println(board1);
  }
}
