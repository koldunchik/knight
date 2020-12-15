import java.util.List;

class Application {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please use start and end positions as command line parameters (e.g. A1 E6)");
      System.exit(0);
    }

    Board board = new Board(Utils.BOARD_COLS, Utils.BOARD_ROWS);

    int startX = Utils.coords2xy(args[0].toUpperCase()).x;
    int startY = Utils.coords2xy(args[0].toUpperCase()).y;

    int endX = Utils.coords2xy(args[1].toUpperCase()).x;
    int endY = Utils.coords2xy(args[1].toUpperCase()).y;

    System.out.println("\n   Start:" + Utils.xy2coords(startX, startY));
    System.out.println("\n   End  :" + Utils.xy2coords(endX, endY));

    Knight knight = new Knight(board);
    Finder finder = new Finder(board, knight, Utils.MOVES_THRESHOLD);

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);

    if (allRoutes.size() > 0) {
      System.out.println("\n   Found routes:\n");

      for (List<Position> route : allRoutes) {
        System.out.println("   " + Utils.route2string(route) + "\n");
      }

    } else {
      System.out.println("\n   No solution has been found!");
    }

    System.out.println(board);
  }
}
