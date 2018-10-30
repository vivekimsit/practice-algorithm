import java.util.*;

class Point implements Comparable<Point> {
  int x;
  int y;
  double distance;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
    this.distance = Integer.MAX_VALUE;
  }

  void setDistance(Point origin) {
    this.distance = Math.sqrt(Math.pow(x - origin.x, 2) + Math.pow(y - origin.y, 2));
  }

  @Override
  public int compareTo(Point other) {
    return this.distance - other.distance > 0 ? 1 : -1;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

class KNearestPoints {
  Point center;
  List<Point> points;

  KNearestPoints(Point center, List<Point> points) {
    this.center = center;
    this.points = points;
  }

  List<Point> solve(int k) {
    if (points.size() <= k) {
      return points;
    }
    Queue<Point> maxPq = new PriorityQueue<>((p1, p2) -> p2.compareTo(p1));
    for (Point p : points) {
      p.setDistance(center);
      maxPq.offer(p);
      if (maxPq.size() > k) {
        maxPq.poll();
      }
    }

    System.out.println(maxPq.size());
    List<Point> result = new ArrayList<>();
    Point p = null;
    while ((p = maxPq.poll()) != null) {
      result.add(p);
    }
    return result;
  }
}

class Main {
  public static void main(String[] args) {
    Point origin = new Point(1, 2);
    List<Point> points = Arrays.asList(
      new Point(0, 0),
      new Point(5, 4),
      new Point(3, 1)
    );
    System.out.println(
      new KNearestPoints(origin, points).solve(2));
  }
}
