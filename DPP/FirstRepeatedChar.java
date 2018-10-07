import java.util.*;

class FirstRepeatedChar {
  private static Character findRepeated(String text) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (seen.contains(ch)) return ch;
      else seen.add(ch);
    }
    return null;
  }
  public static void main(String[] args) {
    System.out.println(findRepeated(""));
    System.out.println(findRepeated("aaaa"));
    System.out.println(findRepeated("aabb"));
    System.out.println(findRepeated("abbc"));
    System.out.println(findRepeated("abcd"));
  }
}
