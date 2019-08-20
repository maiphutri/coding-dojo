public class StringManipulator {
  public String trimAndConcat(String word1, String word2) {
    return word1.trim() + word2.trim();
  }

  public Integer getIndexOrNull(String word, char letter) {
    return word.indexOf(letter) != -1 ? word.indexOf(letter) : null;
  }

  public Integer getIndexOrNull(String word1, String word2) {
    return word1.indexOf(word2) != -1 ? word1.indexOf(word2) : null;
  }

  public String concatSubstring(String word1, int num1, int num2, String word2) {
    return word1.substring(num1, num2) + word2;
  }
}