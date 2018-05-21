// h e l l o
class ReverseString {
  static char[] solve(char[] chars) {
    int lo = 0;
    int hi = chars.length - 1;
    while (lo < hi) {
      char temp = chars[lo];
      chars[lo] = chars[hi];
      chars[hi] = temp;

      lo++;
      hi--;
    }
    return chars;
  }

  public static void main(String[] args) {
    System.out.println(solve(new char[]{'h', 'e', 'l', 'l', 'o'}));
  }
}
