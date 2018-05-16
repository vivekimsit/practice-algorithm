import java.util.Stack;

// for any state change check pre and post conditions.
class ParenthesisValidator {
  static boolean solve(String text) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(0);
      if ("{[(".indexOf(ch) > 0) {
        stack.push(ch);
      }
      else if ("}])".indexOf(ch) > 0) {
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
    solve(null);
    solve("");
    solve("[{(");
    solve("[]");
    solve("[{()}]");
  }
}
