import java.util.Stack;


class MaxStack {
  private final Stack<Integer> inputStack = new Stack<>();
  private final Stack<Integer> maxStack = new Stack<>();

  void push(final int item) {
    inputStack.push(item);
    if (maxStack.empty() || maxStack.peek() <= item) {
      maxStack.push(item);
    }
  }

  int pop() {
    int top = inputStack.pop();
    if (top == maxStack.peek()) {
      maxStack.pop();
    }
    return top;
  }

  int getMax() {
    return maxStack.peek();
  }

  public static void main(String[] args) {
    MaxStack example = new MaxStack();
    example.push(3);
    System.out.println(example.getMax());
    example.push(2);
    System.out.println(example.getMax());
    example.push(1);
    System.out.println(example.getMax());
    example.push(5);
    System.out.println(example.getMax());
  }
}
