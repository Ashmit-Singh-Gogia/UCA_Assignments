#include <stdio.h>
#include <stdlib.h>

int isPower2(int num) {
  int isPositive = !(num >> 31);
  int isNonZero = !!num;
  int isSingleBit = !(num & (num + ~0));
  return isNonZero & isSingleBit & isPositive;
}

int main(int argc, char *argv[]) {
  if (argc != 2) {
    printf("Usage %s [number]\n", argv[0]);
    exit(-1);
  }
  int num = atoi(argv[1]), shifts = atoi(argv[1]);
  printf("%x\n", isPower2(num));
  return 0;
}