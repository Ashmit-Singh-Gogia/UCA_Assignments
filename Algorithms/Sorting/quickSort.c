#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

bool verifySort(int arr[], int size) {
  for (int i = 1; i < size; i++) {
    if (arr[i] < arr[i - 1])
      return false;
  }

  return true;
}

void quickSort(int arr[], int low, int high) {
  if (low >= high)
    return;
  int mid = low + (high - low) / 2;
  int pivot = arr[mid];
  int i = low, j = high;
  while (i <= j) {
    while (arr[i] < pivot) {
      i++;
    }
    while (arr[j] > pivot) {
      j--;
    }
    if (i <= j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
  quickSort(arr, low, j);
  quickSort(arr, i, high);
}

int main() {
  int array1[] = {54, 32, 1, 3, 4, 2, 78, 65, 4, 3, 45, 89, 43};
  quickSort(array1, 0, 12);

  if (verifySort(array1, 13)) {
    printf("The array is sorted\n");
  } else {
    printf("The array is not sorted\n");
  }

  return 0;
}