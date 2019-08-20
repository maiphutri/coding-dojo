public class FizzBuzz {
  public String fizzBuzz(int number) {
    String newString;
    if (number % 3 == 0 && number % 5 == 0) {
      return newString = "FizzBuzz";
    }
    if (number % 3 == 0) {
      return newString = "Fizz";
    } 

    if (number % 5 == 0) {
      return newString = "Buzz";
    } 

    return String.valueOf(number);
  }
}