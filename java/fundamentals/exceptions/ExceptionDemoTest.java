import java.util.ArrayList;
public class ExceptionDemoTest {
  public static void main(String[] args) {
    ArrayList<Object> myList = new ArrayList<Object>();
    myList.add(10);
    myList.add("2");
    myList.add(48);
    myList.add("9");
    for(int i = 0; i < myList.size(); i++) {
      try {
        Integer castedValue = (Integer) myList.get(i);
      } catch (ClassCastException e) {
        System.out.println("Hey! There is an error at index: " + i + " with value: " + myList.get(i));
      }
    }
  }
}