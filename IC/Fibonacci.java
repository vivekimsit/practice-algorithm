public class Fibonacci {
  static int SolveRecursive(final int num) {
    if (num <= 1) return num;
    return SolveRecursive(num - 1) + SolveRecursive(num - 2);
  }

  static int SolveRecursiveTopDown(final int num) {
    if (num <= 1) return num;

    int[] cache = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      cache[i] = -1;
    }
    cache[0] = 0;
    cache[1] = 1;
    return SolveRecursiveTopDown(num, cache);
  }

  static int SolveRecursiveBottomUp(final int num) {
    if (num <= 1) return num;

    int[] cache = new int[num + 1];
    cache[0] = 0;
    cache[1] = 1;

    for (int i = 2; i <= num; i++) {
      cache[i] = cache[i - 1] + cache[i - 2];
    }
    return cache[num];
  }

  private static int SolveRecursiveTopDown(final int num, int[] cache) {
    if (cache[num] >= 0) return cache[num];

    cache[num] = SolveRecursiveTopDown(num - 1, cache) + SolveRecursiveTopDown(num - 2, cache);
    return cache[num];
  }

  private static void print(final int value) {
    System.out.println(value);
  }

  public static void main(final String[] args) {
    print(SolveRecursive(6));
    print(SolveRecursiveTopDown(6));
    print(SolveRecursiveBottomUp(6));
  }
}
