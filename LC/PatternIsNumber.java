import java.util.*;

class PatternIsNumber {
  private static boolean isNumber(String pattern) {
    boolean seenDecimal = false;

    int length = pattern.length();
    int current = 0;
    while (current < length) {
      char ch = pattern.charAt(current);
      if (ch == ' ') {
        return false;
      }
      if (!Character.isDigit(ch)) {
        if (ch == '.') {
          if (seenDecimal) return false;
          seenDecimal = true;
        } else if (ch == '-' || ch == 'e') {
          if (ch == '-' && current > 0) {
            char prev = pattern.charAt(current - 1);
            if (prev != 'e') return false;
          }
          if (current + 1 == length) return false;
          char next = pattern.charAt(current + 1);
          if (ch == 'e' && next == '-') {
            current++;
            continue;
          }
          if (!Character.isDigit(next)) return false;
        } else {
          return false;
        }
      }
      current++;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isNumber("10") == true);
    System.out.println(isNumber("10.01") == true);
    System.out.println(isNumber("10..01") == false);
    System.out.println(isNumber("10.0.1") == false);
    System.out.println(isNumber("-10") == true);
    System.out.println(isNumber("--10") == false);
    System.out.println(isNumber("1e5") == true);
    System.out.println(isNumber("1e-5") == true);

    System.out.println(isNumber("1b5") == false);
    System.out.println(isNumber("-") == false);
    System.out.println(isNumber("--") == false);
    System.out.println(isNumber("a") == false);
    System.out.println(isNumber("e") == false);
    System.out.println(isNumber("x 1") == false);
    System.out.println(isNumber("a -2") == false);
    System.out.println(isNumber("192.168.1.1") == false);
    System.out.println(isNumber("10-10") == false);
    System.out.println(isNumber("10-") == false);
  }
}
