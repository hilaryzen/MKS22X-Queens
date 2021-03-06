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

    System.out.println(" ");

    QueenBoard board2 = new QueenBoard(30);
    System.out.println(board2.solve());
    System.out.println(board2);

    System.out.println(" ");

    QueenBoard board3 = new QueenBoard(3);
    System.out.println(board3.solve());
    System.out.println(board3);

    System.out.println(" ");

    QueenBoard board4 = new QueenBoard(4);
    System.out.println("Number of solutions for size 4: " + board4.countSolutions());
    QueenBoard board5 = new QueenBoard(14);
    System.out.println("Number of solutions for size 14: " + board5.countSolutions());

    System.out.println(" ");

    System.out.println(board.solve()); //Should throw exception
  }
}
