class Main {
  static int findRotationIndex(final String[] words) {
    int L = 0;
    int R = words.length - 1;
    while (words[L].compareTo(words[R]) > 0) {
      int M = L + (R - L) / 2;
      if (words[M].compareTo(words[R]) > 0) {
        L = M + 1;
      }
      else {
        R = M;
      }
    }
    return L;
  }

  public static void main(String[] args) {
    String[] words = new String[]{
      "ptolemaic",
    };
    System.out.println(findRotationIndex(words)); // 5

    words = new String[]{
      "ptolemaic",
      "retrograde",
      "supplant",
      "undulate",
      "xenoepist",
      "asymptote",  // <-- rotates here!
      "babka",
      "banoffee",
      "engender",
      "karpatka",
      "othellolagkage",
    };
    System.out.println(findRotationIndex(words)); // 5

    words = new String[]{
      "undulate",
      "xenoepist",
      "asymptote",  // <-- rotates here!
      "babka",
      "banoffee",
      "engender",
      "karpatka",
      "othellolagkage",
    };
    System.out.println(findRotationIndex(words)); // 2
  }
}
