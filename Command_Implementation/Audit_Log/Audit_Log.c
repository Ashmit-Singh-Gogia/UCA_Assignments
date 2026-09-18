#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

void printUsage() {
  printf("Usage: \t./auditlog --add \"YOUR LOG HERE\"\n");
  printf("\t./auditlog --view\n");
  exit(-1);
}

int main(int argc, char *argv[]) {
  // validate the number of args
  if (argc != 2 && argc != 3) {
    printUsage();
  }

  // open the file
  char *filePath = "log.txt";
  char buf[1];
  int openFlags = O_CREAT | O_APPEND | O_RDWR;
  mode_t filePerms = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;
  int fd = open(filePath, openFlags, filePerms);

  // check for file opening errors
  if (fd == -1) {
    printf("Error in opening file %s", filePath);
    exit(-1);
  }

  // Check the options
  for (int i = 1; i < argc; i++) {

    if (strcmp(argv[i], "--view") == 0) {
      int numsRead = 0, lineNumber = 1;
      char previous = '\n';
      while ((numsRead = read(fd, buf, 1)) > 0) {
        if (previous == '\n') {
          printf("%d. ", lineNumber);
        }
        if (*buf == '\n') {
          lineNumber++;
        }
        previous = *buf;
        printf("%c", *buf);
      }

      if (numsRead == -1) {
        printf("error reading file %s", filePath);
        exit(-1);
      }
    } else if (strcmp(argv[i], "--add") == 0) {
      if (i == argc - 1) {
        printUsage();
        exit(-1);
      }
      // append the text to the log file
      int bitsWritten = write(fd, argv[i + 1], strlen(argv[i + 1]));
      if (bitsWritten == -1) {
        printf("Error writing the file\n");
        exit(-1);
      }
      write(fd, "\n", 1);
      i++;
    } else if (strcmp(argv[i], "--delete") == 0) {
      if (close(fd) == -1) {
        printf("Error closing the file\n");
        exit(-1);
      }

      // delete the file
      if (unlink(filePath) == -1) {
        printf("Error deleting the file");
        exit(-1);
      }
      printf("Log file deleted\n");
      exit(-1);
    }
  }

  //   close the file;
  if (close(fd) == -1) {
    printf("Error closing the file\n");
    exit(-1);
  }

  return 0;
}
