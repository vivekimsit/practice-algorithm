import java.util.Stack;


class ParenthesisValidator {
  static boolean solve(final String text) {
    if (text == null) return true;

    final Stack<Character> stack = new Stack<>();

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if ("{[(".indexOf(ch) > 0) {
        stack.push(ch);
      }
      else if ("}])".indexOf(ch) > 0) {
        if (stack.size() == 0) {
          return false;
        }
        char top = stack.peek();
        if (top == '{' && ch == '}') {
          stack.pop();
        }
        else if (top == '[' && ch == ']') {
          stack.pop();
        }
        else if (top == '(' && ch == ')') {
          stack.pop();
        }
      }
    }

    return stack.empty();
  }

  public static void main(String[] args) {
    System.out.println(solve(null));
    System.out.println(solve(""));
    System.out.println(solve("[{("));
    System.out.println(solve("[]"));
    System.out.println(solve("[{()}]"));
  }
}
