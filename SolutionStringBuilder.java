import java.util.Scanner;

public class SolutionStringBuilder {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String needle = scanner.next();
    String haystack = scanner.next();
    scanner.close();

    boolean needle_in_haystack = checkForNeedleInHaystack(needle, haystack);
    System.out.println(needle_in_haystack);
  }

  public static boolean checkForNeedleInHaystack(String needle, String haystack) {

    int needle_length = needle.length();
    int haystack_length = haystack.length();
    int start = 0;
    int end = start + needle_length;

    while (end <= haystack_length) {
      StringBuilder sb = new StringBuilder(needle);

      for (int i = needle_length - 1; i >= 0; i--) {
        String check_substring = haystack.substring(start, end);
        int index = sb.indexOf(Character.toString(check_substring.charAt(i)));
        if (index == -1) {
          start = end - (needle_length - i) + 1;
          end = start + needle_length;
          break;
        }
        sb.deleteCharAt(index);
      }

      if (sb.length() == 0) {
        return true;
      }
    }

    return false;
  }
}
