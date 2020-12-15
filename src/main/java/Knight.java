import java.util.LinkedList;
import java.util.List;

public class Knight implements ChessPiece {
  private final Board board;

  Knight(Board board) {
    this.board = board;
  }

  @Override
  public List<Position> getAvailablePositions(int x, int y, int value) {
    List<Position> result = new LinkedList<>();

    if (x - 2 >= 0 && y - 1 >= 0) {
      result.add(new Position(x - 2, y - 1, value));
    }

    if (x - 2 >= 0 && y + 1 < board.sizeY) {
      result.add(new Position(x - 2, y + 1, value));
    }

    if (x - 1 >= 0 && y - 2 >= 0) {
      result.add(new Position(x - 1, y - 2, value));
    }

    if (x - 1 >= 0 && y + 2 < board.sizeY) {
      result.add(new Position(x - 1, y + 2, value));
    }


    if (x + 2 < board.sizeX && y - 1 >= 0) {
      result.add(new Position(x + 2, y - 1, value));
    }

    if (x + 2 < board.sizeX && y + 1 < board.sizeY) {
      result.add(new Position(x + 2, y + 1, value));
    }

    if (x + 1 < board.sizeX && y - 2 >= 0) {
      result.add(new Position(x + 1, y - 2, value));
    }

    if (x + 1 < board.sizeX && y + 2 < board.sizeY) {
      result.add(new Position(x + 1, y + 2, value));
    }

    return result;
  }

}
