import java.util.*;


class Main {
  public static List<Integer> solve(List<Integer> list, int target) {
    List<List<Integer>> result = new ArrayList<>();
    solveHelper(list, target, new ArrayList<>(), result);
    if (result.size() >= 1) {
      return result.get(0);
    } else {
      return null;
    }
  }

  private static void solveHelper(
      List<Integer> list, int target, List<Integer> chosen, List<List<Integer>> res) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(chosen));
    } else if (!list.isEmpty()) {
      Integer n = list.get(0);
      list.remove(0);
      // chose, explore without n
      solveHelper(list, target, chosen, res);

      // chose, explore with n
      chosen.add(n);
      solveHelper(list, target - n, chosen, res);

      // un-chose
      chosen.remove(chosen.size() - 1);
      list.add(0, n);
    }
  }

  public static void main(String[] args) {
    System.out.println(solve(new ArrayList<>(Arrays.asList(12)), 12)); // 12
    System.out.println(solve(new ArrayList<>(Arrays.asList(12)), 15)); // null
    System.out.println(solve(new ArrayList<>(Arrays.asList(12, 1, 61, 5, 9, 2)), 24));
  }
}
