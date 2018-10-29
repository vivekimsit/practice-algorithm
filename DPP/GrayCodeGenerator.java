import java.util.*;

class GrayCode {
  private int size;

  GrayCode(int size) {
    this.size = size;
  }

  List<Integer> solve() {
    return solve(size);
  }

  private List<Integer> solve(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    if (n == 1) {
      return Arrays.asList(0, 1);
    }
    List<Integer> prev = solve(n - 1);
    List<Integer> res  = new ArrayList<>();
    for (int num : prev) {
      res.add(num);
    }
    Collections.reverse(prev);
    for (int num: prev) {
      res.add((1 << n - 1) + num);
    }
    return res;
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println(new GrayCode(0).solve());
    System.out.println(new GrayCode(1).solve());
    System.out.println(new GrayCode(2).solve());
    System.out.println(new GrayCode(3).solve());
  }
}
