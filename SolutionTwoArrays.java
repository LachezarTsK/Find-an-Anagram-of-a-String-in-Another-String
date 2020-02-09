import java.util.Scanner;

public class SolutionTwoArrays {
  private static final int LETTERS_ALPHABET = 26;
  private static final int ASCII_A_LOWERCASE = 97;
  private static char[] array_needle;
  private static char[] array_haystack;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String needle = scanner.next();
    String haystack = scanner.next();
    scanner.close();

    boolean needle_in_haystack = checkForNeedleInHaystack(needle, haystack);
    System.out.println(needle_in_haystack);
  }

  private static boolean arraysAreEqual() {
    for (int i = 0; i < LETTERS_ALPHABET; i++) {
      if (array_needle[i] != array_haystack[i]) {
        return false;
      }
    }
    return true;
  }

  private static void initializeArrays(String needle, String haystack) {
    array_needle = new char[LETTERS_ALPHABET];
    array_haystack = new char[LETTERS_ALPHABET];

    for (int i = 0; i < needle.length(); i++) {
      array_needle[needle.charAt(i) - ASCII_A_LOWERCASE]++;
      array_haystack[haystack.charAt(i) - ASCII_A_LOWERCASE]++;
    }
  }

  public static boolean checkForNeedleInHaystack(String needle, String haystack) {
    initializeArrays(needle, haystack);
    int needle_length = needle.length();
    int haystack_length = haystack.length();

    for (int i = needle_length; i < haystack_length; i++) {
      if (arraysAreEqual()) {
        return true;
      }
      array_haystack[haystack.charAt(i - needle_length) - ASCII_A_LOWERCASE]--;
      array_haystack[haystack.charAt(i) - ASCII_A_LOWERCASE]++;
    }
    if (arraysAreEqual()) {
      return true;
    }
    return false;
  }
}
