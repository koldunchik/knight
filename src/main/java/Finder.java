import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Finder {
    final Board board;
    final ChessPiece chessPiece;
    final int movesThreshold;

    Finder(Board board, ChessPiece chessPiece, int movesThreshold) {
      this.board = board;
      this.chessPiece = chessPiece;
      this.movesThreshold = movesThreshold;
    }

    void fillBoard(int startX, int startY) {
      board.field[startX][startY] = new Cell(0);

      List<Position> positions = chessPiece.getAvailablePositions(startX, startY, 1);

      while (!positions.isEmpty()) {
          Position position = positions.remove(0);
          if (board.field[position.x][position.y] == null) {
              board.field[position.x][position.y] = new Cell(position.value);
              positions.addAll(chessPiece.getAvailablePositions(position.x, position.y, position.value + 1));
          }
      }
    }

    void buildRoutes(List<List<Position>> allRoutes, List<Position> prevRoute, int endX, int endY) {
        if (endX < 0 || endY < 0 || endX >= board.sizeX || endY >= board.sizeY) {
            return;
        }

        if (board.field[endX][endY] == null || board.field[endX][endY].value < 0) {
            return;
        }

        board.field[endX][endY].marked = true;

        int value = board.field[endX][endY].value;

        if (value == 0) {
          allRoutes.add(prevRoute);
          return;
        }

        List<Position> positions = chessPiece.getAvailablePositions(endX, endY, value - 1).stream().filter(
            position -> board.field[position.x][position.y].value == position.value
        ).collect(Collectors.toList());

        for (Position position: positions) {
          board.field[position.x][position.y].marked = true;

          List<Position> newPath;
          newPath = new ArrayList<>(prevRoute.size());
          newPath.addAll(prevRoute);
          newPath.add(position);
          buildRoutes(allRoutes, newPath, position.x, position.y);
        }

    }

  List<List<Position>> getAllRoutes(int startX, int startY, int endX, int endY) {
    List<List<Position>> allPaths = new ArrayList<>();

    fillBoard(startX, startY);

    if (board.field[endX][endY] == null ||
        board.field[endX][endY].value > movesThreshold) {
      return allPaths;
    }

    List<Position> previousRoute = new ArrayList<>();
    previousRoute.add(new Position(endX, endY));
    buildRoutes(allPaths, previousRoute, endX, endY);

    return allPaths;
  }


}
