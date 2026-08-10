#include <stdio.h>
#include <stdlib.h>

/*
 * bang - Compute !x without using !
 *   Examples: bang(3) = 0, bang(0) = 1
 *   Legal ops: ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 4
 */

int bang(int x) { return ((x | (~x + 1)) >> 31) + 1; }

int main(int argc, char *argv[]) {
  if (argc != 2) {
    printf("Usage %s %s\n", argv[0], "[any number]");
    exit(-1);
  }

  int num = atoi(argv[1]);

  printf("%d\n", bang(num));
  return 0;
}