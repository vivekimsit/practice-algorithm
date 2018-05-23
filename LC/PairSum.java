import java.util.Map;
import java.util.HashMap;

class PairSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    int[] result = {-1, -1};
    for (int i = 0; i < nums.length; i++) {
      if (seen.containsKey(target - nums[i])) {
        result[0] = seen.get(target - nums[i]);
        result[1] = i;
      }
      else {
        seen.put(nums[i], i);
      }
    }
    return result;
  }
}

