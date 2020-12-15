public class Position {
    final int x;
    final int y;
    final int value;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = -1;
    }

    Position(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public String toString() {
        return Utils.xy2coords(x,y);
    }
}
