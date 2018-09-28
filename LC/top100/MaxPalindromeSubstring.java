import java.util.*;

class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 1) return s;

    String maxPalindromeSoFar = "";
    for (int i = 0; i < s.length(); i++) {
      maxPalindromeSoFar = longer(
          maxPalindromeSoFar,
          longer(expandingPalindrome(s, i, i), expandingPalindrome(s, i, i + 1)));
    }
    return maxPalindromeSoFar;
  }

  private String expandingPalindrome(String str, int lo, int hi) {
    while (0 <= lo && hi < str.length() && str.charAt(lo) == str.charAt(hi)) {
      lo--;
      hi++;
    }
    return str.substring(lo + 1, hi);
  }

  private String longer(String s1, String s2) {
    return s1.length() > s2.length() ? s1 : s2;
  }
}
