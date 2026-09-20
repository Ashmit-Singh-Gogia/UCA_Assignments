#include <signal.h>
#include <stdio.h>
#include <unistd.h>

static int count = 0;

void handle_sigint() {
  count++;
  if (count == 3) {
    printf("Terminating the process : Count of CTRL + C is: %d\n", count);
    raise(SIGTERM);
  }
  printf("SIGINT received , but i am not exiting the process\n");
}

int main() {

  printf("Start of the program\n");

  signal(SIGINT, handle_sigint); // SIGINT is signal 2

  while (1) {
    printf("Running Process..........\n");
    sleep(1);
  }

  return 0;
}