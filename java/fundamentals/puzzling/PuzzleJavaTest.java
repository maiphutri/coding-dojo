public class PuzzleJavaTest {
  public static void main(String[] args) {
    PuzzleJava puzzle = new PuzzleJava();

    System.out.println(puzzle.greaterThan10());
    System.out.println(puzzle.nameLessThan5());
    puzzle.alphabet();
    System.out.println(puzzle.rand55to100());
    puzzle.sortRandom();
    System.out.println(puzzle.randStr());
    System.out.println(puzzle.arrRandStr());
  }
}