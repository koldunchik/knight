import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class FinderTest {
  private Board board;
  private ChessPiece chessPiece;
  private Finder finder;

  @Before
  public void setUp() {
    board = new Board(Utils.BOARD_COLS, Utils.BOARD_ROWS);
    chessPiece = new Knight(board);
    finder = new Finder(board, chessPiece,  Utils.MOVES_THRESHOLD);
  }

  @Test
  public void e2e4() {
    int startX = Utils.coords2xy("E2").x;
    int startY = Utils.coords2xy("E2").y;
    int endX = Utils.coords2xy("E4").x;
    int endY = Utils.coords2xy("E4").y;

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);
    List<String> strs = allRoutes.stream().map(Utils::route2string).collect(Collectors.toList());

    assertThat(strs, hasSize(2));

    assertThat(strs,containsInAnyOrder(
        "E2 -> C3 -> E4",
        "E2 -> G3 -> E4")
    );
  }

  @Test
  public void e2h8() {
    int startX = Utils.coords2xy("E2").x;
    int startY = Utils.coords2xy("E2").y;
    int endX = Utils.coords2xy("H8").x;
    int endY = Utils.coords2xy("H8").y;

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);
    List<String> strs = allRoutes.stream().map(Utils::route2string).collect(Collectors.toList());

    assertThat(strs, hasSize(1));

    assertThat(strs,containsInAnyOrder(
        "E2 -> F4 -> G6 -> H8")
    );
  }

  @Test
  public void e2h7() {
    int startX = Utils.coords2xy("E2").x;
    int startY = Utils.coords2xy("E2").y;
    int endX = Utils.coords2xy("H7").x;
    int endY = Utils.coords2xy("H7").y;

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);

    assertThat(allRoutes, hasSize(0));
  }

  @Test
  public void c3b1() {
    int startX = Utils.coords2xy("C3").x;
    int startY = Utils.coords2xy("C3").y;
    int endX = Utils.coords2xy("B1").x;
    int endY = Utils.coords2xy("B1").y;

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);
    List<String> strs = allRoutes.stream().map(Utils::route2string).collect(Collectors.toList());

    assertThat(strs, hasSize(1));

    assertThat(strs,containsInAnyOrder(
        "C3 -> B1")
    );
  }

  @Test
  public void a1e6() {
    int startX = Utils.coords2xy("A1").x;
    int startY = Utils.coords2xy("A1").y;
    int endX = Utils.coords2xy("E6").x;
    int endY = Utils.coords2xy("E6").y;

    List<List<Position>> allRoutes = finder.getAllRoutes(startX, startY, endX, endY);
    List<String> strs = allRoutes.stream().map(Utils::route2string).collect(Collectors.toList());

    assertThat(strs, hasSize(3));

    assertThat(strs,containsInAnyOrder(
        "A1 -> B3 -> C5 -> E6",
        "A1 -> B3 -> D4 -> E6",
        "A1 -> C2 -> D4 -> E6")
    );
  }

}