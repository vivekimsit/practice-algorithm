import java.util.*;

public class PermutationII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    dfs(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, boolean []used) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
        used[i] = true;
        path.add(nums[i]);
        dfs(nums, result, path, used);
        used[i] = false;
        path.remove(path.size() - 1);
      }
    }
  }
}
