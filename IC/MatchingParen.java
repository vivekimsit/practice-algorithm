class MatchingParen {
  static int solve(final String text, final int pos) {
    int closingParamsNeeded = 1;
    int closingParamPosition = -1;
    for (int i = pos + 1; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (ch == '(') {
        closingParamsNeeded += 1;
      }
      else if (ch == ')') {
        closingParamsNeeded -= 1;
      }
      if (closingParamsNeeded == 0) {
        closingParamPosition = i;
        break;
      }
    }
    return closingParamPosition;
  }

  public static void main(String[] args) {
    System.out.println(
        solve(
          "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));
  }
}
