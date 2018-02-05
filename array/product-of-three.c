#include <stdio.h>

#define MAX(a, b) (((a) > (b)) ? (a) : (b))
#define MIN(a, b) (((a) < (b)) ? (a) : (b))

/**
 * [1, 10, -5, 1, -100] -> 1 * -5 * -100
 */
int highestProductOf3(const int *arrayOfInts, size_t length) {
  // assert(length >= 3);

  size_t i;
  int highest, lowest;
  int highestProductOf2, lowestProductOf2, highestProductOf3;

  highest = MAX(arrayOfInts[0], arrayOfInts[1]);
  lowest  = MIN(arrayOfInts[0], arrayOfInts[1]);

  highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
  lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

  highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

  for (i = 2; i < length; i++) {
    int temp;
    int current = arrayOfInts[i];

    temp = MAX(highestProductOf3, current * highestProductOf2);
    highestProductOf3 = MAX(temp, current * lowestProductOf2);

    temp = MAX(highestProductOf2, current * highest);
    highestProductOf2 = MAX(temp, current * lowest);

    temp = MIN(lowestProductOf2, current * highest);
    lowestProductOf2 = MIN(temp, current * lowest);

    highest = MAX(highest, current);
    lowest = MIN(lowest, current);
  }

  return highestProductOf3;
}

int main() {
  int arr[] = {1, 10, -5, -1, -100};
  printf("%d\n", highestProductOf3(arr, 5));
  return 0;
}
