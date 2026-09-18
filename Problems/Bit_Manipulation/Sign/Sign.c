#include <stdio.h>
#include <stdlib.h>

int sign(int num) { return !!(num) | (num >> 31); }

int main(int argc, char *argv[]) {

  if (argc != 2) {
    printf("Usage %s [number]\n", argv[0]);
    exit(-1);
  }

  int num = atoi(argv[1]);
  printf("%d\n", sign(num));

  return 0;
}