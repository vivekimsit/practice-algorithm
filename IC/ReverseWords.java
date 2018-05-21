class ReverseWords {
  static char[] solve(char[] chars) {
    int lo = 0;
    int hi = chars.length - 1;

    reverse(chars, lo, hi);

    int currentWordsStart = 0;
    for (int i = 0; i <= chars.length; i++) {
      if (i == chars.length || chars[i] == ' ') {
        reverse(chars, currentWordsStart, i - 1);
        currentWordsStart = i + 1;
      }
    }
    return chars;
  }

  static void reverse(char[] chars, int lo, int hi) {
    while (lo < hi) {
      char temp = chars[lo];
      chars[lo] = chars[hi];
      chars[hi] = temp;

      lo++;
      hi--;
    }
  }

  public static void main(String[] args) {
    char[] chars = "cake pound steal".toCharArray();
    System.out.println(solve(chars));
  }
}
