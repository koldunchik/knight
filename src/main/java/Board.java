import java.util.Collections;

class Board {
  final int sizeX;
  final int sizeY;
  final Cell[][] field;

  Board(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.field = new Cell [sizeX][sizeY];
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("\n    ");

    for (int k = 0; k < sizeX; k++) {
      result.append("  ");
      result.append(Utils.num2letter(k));
      result.append("  ");
    }

    result.append("\n");
    result.append("   +");
    result.append(String.join("", Collections.nCopies(sizeX, "-----")));
    result.append("\n");

    for (int i = 0; i < sizeY; i++) {
      result.append(" ").append(i + 1).append(" ");
      result.append("|");
      for (int j = 0; j < sizeX; j++) {
        Cell cell = field[j][i];
        result.append("  ");
        result.append(cell != null ? cell : ".");
        result.append("  ");
      }
      result.append("\n");
      if (i < sizeY -1 ) {
        result.append("   |\n   |\n");
      }
    }

    result.append("   +");
    result.append(String.join("", Collections.nCopies(sizeX, "-----")));
    result.append("\n    ");

    for (int k = 0; k < sizeX; k++) {
      result.append("  ");
      result.append(Utils.num2letter(k));
      result.append("  ");
    }
    result.append("\n\n\n");

    return result.toString();
  }
}
