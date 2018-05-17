class UniqueValueInDuplicates {
  static int solve(int[] items) {
    int result = 0;
    for (int item : items) {
      result ^= item;
    }
    if (result == 0) {
      throw new Error("No unique value found");
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[]{1}));
    System.out.println(solve(new int[]{2, 2, 3}));
    System.out.println(solve(new int[]{1, 1}));
  }
}
