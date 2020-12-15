import java.util.List;

class Utils {
  final static Integer BOARD_COLS = 8;
  final static Integer BOARD_ROWS = 8;
  final static int MOVES_THRESHOLD = 3;
  private final static String ROUTE_SEPARATOR = " -> ";
  private final static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  static String num2letter(int i) {
    return i < letters.length() ? String.valueOf(letters.charAt(i)) : String.valueOf(i);
  }

  static String xy2coords(int startX, int startY) {
    return num2letter(startX) + (startY + 1);
  }

  static Position coords2xy(String coords) {
    int x = coords.toUpperCase().charAt(0) - 65;
    int y = Integer.parseInt(String.valueOf(coords.toUpperCase().charAt(1))) - 1;
    return new Position(x, y);
  }

  static String route2string(List<Position> route) {
    StringBuilder sb = new StringBuilder();
    for (int i = route.size() - 1; i >= 0; i--) {
      sb.append(route.get(i));
      if (i != 0) {
        sb.append(ROUTE_SEPARATOR);
      }
    }
    return sb.toString();
  }
}
