class Cell {
  final int value;
  boolean marked;

  Cell(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return marked ? String.valueOf(value) : " ";
  }
}
