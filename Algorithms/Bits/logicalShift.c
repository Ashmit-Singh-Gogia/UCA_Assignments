#include <stdio.h>
#include <stdlib.h>

/*
 * logicalShift - shift x to the right by n, using a logical shift
 *   Can assume that 0 <= n <= 31
 *   Examples: logicalShift(0x87654321, 4) = 0x08765432
 *   Legal ops: ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 3
 */

// The << 1 is because when we right shift by n we get an extra 1 on left
int logicalShift(int num, int shifts) {
  return ~(((1 << 31) >> shifts) << 1) & (num >> shifts);
}

int main(int argc, char *argv[]) {
  if (argc != 3) {
    printf("Usage %s [number] [Number of right shifts]\n", argv[0]);
    exit(-1);
  }
  int num = atoi(argv[1]), shifts = atoi(argv[2]);
  printf("%x\n", logicalShift(num, shifts));
  return 0;
}