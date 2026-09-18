#include <stdio.h>
#include <stdlib.h>

// n is the number of bits // x is the number which is checked
int fitBits(int x, int n) { return (((x << (32 - n)) >> (32 - n)) ^ x) + 1; }

int main(int argc, char *argv[]) {
  if (argc != 3) {
    printf("Usage %s [number] [number of bits]", argv[0]);
    exit(-1);
  }
  int number = atoi(argv[1]);
  int bitsSize = atoi(argv[2]);
  if (fitBits(number, bitsSize) == 1) {
    printf("Fits\n");
  } else {
    printf("Does not Fit\n");
  }
  return 0;
}