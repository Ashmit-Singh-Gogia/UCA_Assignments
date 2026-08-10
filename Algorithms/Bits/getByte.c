#include <stdio.h>
#include <stdlib.h>

/*
 * getByte - Extract byte n from word x
 *   Bytes numbered from 0 (LSB) to 3 (MSB)
 *   Examples: getByte(0x12345678,1) = 0x56
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 6
 *   Rating: 2
 */

int getByte(int num, int shift) { return (num >> (shift << 3)) & 255; }

int main(int argc, char *argv[]) {

  if (argc != 3) {
    printf("Usage %s [number] [position of byte]\n", argv[0]);
    exit(-1);
  }
  int num = atoi(argv[1]);
  int shift = atoi(argv[2]);
  printf("%x\n", getByte(num, shift));

  return 0;
}