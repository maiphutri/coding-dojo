import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
  public int[] arrNum(int num) {
    int[] arr;
    if (num == 0) {
      arr = new int[256];
    } else {
      arr = new int[255];
    }
    for (int i=num; i < arr.length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  public void print1to255() {
   for (int num: this.arrNum(1)) {
     System.out.println(num);
   }
  }

  public void printOdd() {
    for (int num: this.arrNum(1)) {
      if (num % 2 == 1) {
        System.out.println(num);
      }
    }
  }

  public void printSum() {
    int sum = 0;
    for (int num : this.arrNum(0)) {
      sum += num;
      System.out.println("Num: " + num + " Sum: " + sum);
    }
  }

  public void iterateArr(int[] arr) {
    for (int num : arr) {
      System.out.println(num);
    }
  }

  public void max(int[] arr) {
    int max = arr[0];
    for (int num: arr) {
      if (max < num) {
        max = num;
      }
    }
    System.out.println("Max number: " + max);
  }

  public void average(int[] arr) {
    int sum = 0;
    for (int num: arr) {
      sum += num;
    }
    System.out.println("Average: " + ((double) sum / arr.length));
  }

  public void greaterThanY(int[] arr, int y) {
    int count = 0;
    for (int num : arr) {
      if (num > y) {
        count++;
      }
    }
    System.out.println("There are " + count + " numbers that are greater than " + y);
  }

  public void square(int[] arr) {
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    for (int i=0; i < arr.length; i++) {
      newArr.add((int) Math.pow(arr[i], 2));
    }
    System.out.println(newArr);
  }

  public void delNegatives(int[] arr) {
    for (int i=0; i < arr.length; i++) {
      if (arr[i] < 0) {
        arr[i] = 0;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public void maxMinAvg(int[] arr) {
    int[] result = {arr[0], arr[0], 0};
    for (int num : arr) {
      System.out.println(num);
      if (result[0] < num) {
        result[0] = num;
      }
      if (result[1] > num) {
        result[1] = num;
      }
      result[2] += num;
    }
    result[2] /= arr.length;
    System.out.println(Arrays.toString(result));
  }

  public void shiftValue(ArrayList<Integer> arr) {
    arr.remove(0);
    arr.add(arr.size(), 0);
    System.out.println(arr);
  }
}