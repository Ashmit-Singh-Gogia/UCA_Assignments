#include <stdio.h>
#include <stdlib.h>

int findNumber(int array[], int n) {
  int ans = 0;
  for (int bit = 0; bit < 32; bit++) {
    int countOfSetBits = 0;
    for (int i = 0; i < n; i++) {
      countOfSetBits += (array[i] >> bit) & 1;
    }
    countOfSetBits = countOfSetBits % 3;
    ans = ans | (countOfSetBits << bit);
  }
  return ans;
}

int main() {
  int array1[] = {1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 4, 3, 3};
  printf("%d\n", findNumber(array1, 13));

  int array2[] = {5, 5, 5, 5};
  printf("%d\n", findNumber(array2, 4));

  int array3[] = {1, 1, 1, 1, 8, 8, 8, 9, 9, 9};
  printf("%d\n", findNumber(array3, 10));

  int array4[] = {2, 2, 2, 99, 99, 99, 99, 4, 4, 4};
  printf("%d\n", findNumber(array4, 10));

  return 0;
}