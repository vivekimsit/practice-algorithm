import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class TripletSumZero {
  public static boolean solve(int[] arr) {
    int length = arr.length;

    assert (length == 3);

    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
          int sum = arr[i] + arr[j] + arr[k];
          if (sum == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean solveSpace(int[] arr) {
    int length = arr.length;

    assert (length == 3);

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        int sum = arr[i] + arr[j];
        set.add(sum);
      }
    }

    for (int i = 0; i < length; i++) {
      int num = arr[i];
      if (set.contains(-num)) {
        return true;
      }
    }
    return false;
  }

  public static boolean solveSpaceTime(int[] arr) {
    int length = arr.length;

    assert (length == 3);

    Arrays.sort(arr);

    for (int i = 0; i < length - 1; i++) {
      int lo = i + 1;
      int hi = length - 1;
      while (lo < hi) {
        int sum = arr[i] + arr[lo] + arr[hi];
        if (sum == 0) {
          return true;
        }
        else if (sum < 0) {
          lo++;
        }
        else {
          hi--;
        }
      }
    }
    return false;
  }

  public static void main(String... args) {
    int[] arr = {0, -1, 2, -3, 1};
    System.out.println(solve(arr));
    System.out.println(solveSpace(arr));
    System.out.println(solveSpaceTime(arr));
  }
}