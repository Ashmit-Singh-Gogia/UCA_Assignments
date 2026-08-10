#include <stdio.h>
#include <stdlib.h>

/*
 * conditional - same as x ? y : z
 *   Example: conditional(2,4,5) = 4
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 16
 *   Rating: 3
 */

int conditional(int x, int y, int z) {
  return ((!!x << 31) >> 31) & y | ~((!!x << 31) >> 31) & z;
}

int main(int argc, char *argv[]) {
  if (argc != 4) {
    printf("Usage %s [Any number] [Any number] [Any number]\n", argv[0]);
    exit(-1);
  }
  int x = atoi(argv[1]), y = atoi(argv[2]), z = atoi(argv[3]);
  printf("%d\n", conditional(x, y, z));
  return 0;
}
