#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
  if (argc != 3) {
    printf("Usage %s %s %s", argv[0], "[any]", "[any]");
    exit(-1);
  }

  return 0;
}