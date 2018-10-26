import java.util.*;

class Main {
  private static int solve(int[] nums) {
    int[] result = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        int isIthBitSet = (num & (1 << i));
        if (isIthBitSet > 0) {
          result[i] = (result[i] + 1) % 3;
        }
      }
    }

    int res = 0;
    for (int i = 0; i < 32; i++) {
      if (result[i] == 1) {
        res += Math.pow(2, i);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[]{3, 3, 3})); //0
    System.out.println(solve(new int[]{1, 3, 3, 3})); // 1
    System.out.println(solve(new int[]{13, 19, 13, 13})); // 19
    System.out.println(solve(new int[]{6, 1, 3, 3, 3, 6, 6})); // 1
  }
}
