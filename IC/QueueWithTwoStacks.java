import java.util.Stack;


class QueueWithTwoStacks<T> {
  private final Stack<T> inStack  = new Stack<>();
  private final Stack<T> outStack = new Stack<>();

  void enqueue(T value) {
    inStack.push(value);
  }

  T dequeue() {
    if (outStack.empty()) {
      while (!inStack.empty()) {
        outStack.push(inStack.pop());
      }
      if (outStack.empty()) {
        throw new Error("Empty queue");
      }
    }
    return outStack.pop();
  }

  public static void main(String[] args) {
    QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
    q.enqueue(1);
    q.enqueue(2);
    System.out.println(q.dequeue() == 1);
  }
}
