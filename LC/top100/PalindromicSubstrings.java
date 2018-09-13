import java.util.*;

class PalindromicSubstrings {
  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) return 0;

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += countPalindrome(s, i, i);
      count += countPalindrome(s, i, i + 1);
    }
    return count;
  }

  private int countPalindrome(String s, int lo, int hi) {
    int count = 0;
    while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
      count++;
      lo--;
      hi++;
    }
    return count;
  }
}
