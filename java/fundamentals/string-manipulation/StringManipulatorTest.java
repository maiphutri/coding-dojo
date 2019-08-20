public class StringManipulatorTest {
  public static void main(String[] args) {
    StringManipulator manipulator = new StringManipulator();
    System.out.println(manipulator.trimAndConcat("  Hello  ", "  World  "));

    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null

    String word = "Hello";
    String subString = "llo";
    String notSubString = "world";
    System.out.println(manipulator.getIndexOrNull(word, subString));
    System.out.println(manipulator.getIndexOrNull(word, notSubString));

    System.out.println(manipulator.concatSubstring("Hello", 1, 2, "world"));
  }
}