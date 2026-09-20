#include <stdio.h>
#include <unistd.h>

int main() {

  fork();
  fork();
  fork();
  fork();

  printf("Hello from PID: %d\n", getpid()); // This line is printed 16 times

  return 0;
}
