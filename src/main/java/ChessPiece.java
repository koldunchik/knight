import java.util.List;

interface ChessPiece {
  List<Position> getAvailablePositions(int x, int y, int value);
}
