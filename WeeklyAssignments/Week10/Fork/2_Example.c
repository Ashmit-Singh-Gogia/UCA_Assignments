/*
fork
A parent process intializes an integer val=10 vefor calling fork. If the child
process modifies val=20, what happens to val in the parent process?

*/

#include <stdio.h>
#include <unistd.h>

int main() {
  printf("Start of the program\n");

  int val = 10;

  int result = fork(); // p = 2 // c1 = 0
  //   p - > p and c2  // c1 -> c1 and c3
  fork(); // p result = 2 c2 result = 2 // c1 result = 0 and c3 result = 0

  if (result == 0) {
    val = 20;
  }

  printf("val: %d \n", val);

  return 0;
}