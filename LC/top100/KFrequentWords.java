import java.util.*;

class KFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {
    int N = words.length;
    if (N == 0 || k <= 0) return new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < N; i++) {
      map.put(words[i], map.getOrDefault(words[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      pq.offer(entry);
      if (pq.size() > k) pq.poll();
    }

    List<String> result = new LinkedList<>();
    while (!pq.isEmpty()) result.add(0, pq.poll().getKey());
    return result;
  }
}
