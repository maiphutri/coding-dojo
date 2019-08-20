import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
  public ArrayList<Integer> greaterThan10() {
    int[] arr1 = {3,5,1,2,7,9,8,13,25,32};
    ArrayList<Integer> arr2 = new ArrayList<>();
    int sum = 0;
    for (int num: arr1) {
      sum += num;
      if (num > 10) {
        arr2.add(num);
      }
    }
    System.out.println(sum);
    return arr2;
  }

  public ArrayList<String> nameLessThan5() {
    ArrayList<String> arr1 = new ArrayList<String>();
    ArrayList<String> arr2 = new ArrayList<String>();
    arr1.add("Nancy");
    arr1.add("Jinichi");
    arr1.add("Fujibayashi");
    arr1.add("Momochi");
    arr1.add("Ishikawa");
    Collections.shuffle(arr1);
    arr1.forEach(name -> {
      System.out.println(name);
      if (name.length() <= 5) {
        arr2.add(name);
      }
    });
    return arr2;
  }

  public void alphabet() {
    ArrayList<Character> alpha = new ArrayList<Character>();
    for (int i = 65; i <= 90; i++) {
      alpha.add((char) i);
    }
    Collections.shuffle(alpha);
    System.out.println(alpha.get(alpha.size() - 1));
    System.out.println(alpha.get(0));
    ArrayList<Character> vowels = new ArrayList<Character>();
    vowels.add('U');
    vowels.add('E');
    vowels.add('O');
    vowels.add('A');
    vowels.add('I');
    if (vowels.contains(alpha.get(0))) {
      System.out.println("First letter is a vowel: " + alpha.get(0));
    }
  }

  public ArrayList<Integer> rand55to100() {
    Random random = new Random();
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int rand = random.nextInt(46) + 55;
      result.add(rand);
    }
    return result;
  }

  public void sortRandom() {
    ArrayList<Integer> rand = this.rand55to100();
    Collections.sort(rand);
    System.out.println(rand);
    System.out.println("Max: " + rand.get(0) + ", Min: " + rand.get(rand.size() - 1));
  }
  
  public String randStr() {
    Random random = new Random();
    String str = "";
    for (int i=0; i < 5; i++) {
      int rand = random.nextInt(26) + 65;
      str += (char) rand;
    }
    return str;
  }

  public ArrayList<String> arrRandStr() {
    ArrayList<String> result = new ArrayList<String>();
    for (int i=0; i < 10; i++) {
      result.add(this.randStr());
    }
    return result;
  }
}