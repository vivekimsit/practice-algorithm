import java.util.*;


class KTopFrequent {
  public List<Integer> topKFrequent(int[] nums, int k) {
    int N = nums.length;
    List<Integer> result = new ArrayList<>();

    if (N == 0 || k <= 0) return result;

    int maxFreq = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < N; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      maxFreq = Math.max(maxFreq, map.get(nums[i]));
    }

    List<Integer> [] bucketList = new LinkedList[maxFreq+1];
    for(int i = 0; i <= maxFreq; i++) {
      bucketList[i] = new LinkedList<>();
    }
    for(Integer key : map.keySet()) {
      int freq = map.get(key);
      bucketList[freq].add(key);
    }

    int count = 0;
    for(int i = maxFreq; i >= 0; i--) {
      for(Integer j: bucketList[i]) {
        if(count < k) {
          result.add(j);
          count++;
        } else {
          return result;
        }
      }
    }
    return result;
  }
}
