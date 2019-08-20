import java.util.ArrayList;

public class BasicJavaTest {
  public static void main(String[] args) {
    BasicJava basics = new BasicJava();
    int[] arr1 = {1,3,5,7,9};
    int[] arr2 = {-2,-5,0,2,8};
    ArrayList<Integer> arr3 = new ArrayList<Integer>();
    arr3.add(1);
    arr3.add(2);
    arr3.add(3);
    basics.print1to255();
    basics.printOdd();
    basics.printSum();
    basics.iterateArr(arr1);
    basics.max(arr2);
    basics.average(arr2);
    basics.greaterThanY(arr1, 3);
    basics.square(arr1);
    basics.delNegatives(arr2);
    basics.maxMinAvg(arr1);
    basics.shiftValue(arr3);
  }
}