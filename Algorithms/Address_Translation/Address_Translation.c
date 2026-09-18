#include <stdio.h>
#include <stdlib.h>

int getOffset(int number) {
  int mask = (1 << 12) - 1;
  return mask & number;
}

int getPageNumber(int number) { return number >> 12; }

int main() {

  // Test case 1
  int testCase1 = 0x00000000;
  int testCase2 = 0x00000FFF;
  int testCase3 = 0x00001000;
  int testCase4 = 0x00003A2C;

  printf("[1A] Addr: 0x%X -> Page: %d (0x%X), Offset: %d (0x%X)\n", testCase1,
         getPageNumber(testCase1), getPageNumber(testCase1),
         getOffset(testCase1), getOffset(testCase1));

  printf("[1A] Addr: 0x%X -> Page: %d (0x%X), Offset: %d (0x%X)\n", testCase2,
         getPageNumber(testCase2), getPageNumber(testCase2),
         getOffset(testCase2), getOffset(testCase2));

  printf("[1A] Addr: 0x%X -> Page: %d (0x%X), Offset: %d (0x%X)\n", testCase3,
         getPageNumber(testCase3), getPageNumber(testCase3),
         getOffset(testCase3), getOffset(testCase3));

  printf("[1A] Addr: 0x%X -> Page: %d (0x%X), Offset: %d (0x%X)\n", testCase4,
         getPageNumber(testCase4), getPageNumber(testCase4),
         getOffset(testCase4), getOffset(testCase4));

  return 0;
}