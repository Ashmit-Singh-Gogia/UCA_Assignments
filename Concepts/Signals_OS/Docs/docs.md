#Signals in OS

## Signals are small asynchronous notificationsa sent by OS to a process.

> Its basically Os telling a process that some event has occured.

### Some popular signals are : 
1. SIGINT ( sent on CTRL + C ) -> can be used as default or ignored or custom implentation
2. SIGTERM ( kill PID ) -> can be used as default or ignored or custom implentation
3. SIGKILL ( kill -9 PID) -> can not be caught , cant be ignored , no custom logic is allowed
4. SIGSTOP ( sent on CTRL + Z ) -> can be used as default or ignored or custom implentation -> Used to stop a process



```
# Signal handler code

#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void handler(int signal) {
    printf("SIGINT received!\n");
}

int main() {
    signal(SIGINT, handler);

    while (1) {
        printf("Running...\n");
        sleep(1);
    }
}

```

