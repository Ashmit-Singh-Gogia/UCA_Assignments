#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

int size = 0;
int size_of() { return size; }
int get_parent(int index) { return (index - 1) / 2; }
int getLeft(int index) { return index * 2 + 1; }
int getRight(int index) { return index * 2 + 2; }

void swap(int heap[], int left, int right) {
  int temp = heap[left];
  heap[left] = heap[right];
  heap[right] = temp;
}

bool isEmpty() { return size == 0; }

void heapUp(int heap[], int index) {
  if (index == 0) {
    return;
  }
  if (heap[get_parent(index)] < heap[index]) {
    swap(heap, get_parent(index), index);
    heapUp(heap, get_parent(index));
  }
}

void heapDown(int heap[], int index) {
  int max = index;
  int left = getLeft(max), right = getRight(max);
  if (left < size && heap[left] > heap[max]) {
    max = left;
  }
  if (right < size && heap[right] > heap[max]) {
    max = right;
  }
  if (max != index) {
    swap(heap, max, index);
    heapDown(heap, max);
  }
}

int pop(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  int maxValue = heap[0];
  heap[0] = heap[size - 1];
  size--;
  heapDown(heap, 0);

  return maxValue;
}

void push(int heap[], int value) {
  heap[size++] = value;
  heapUp(heap, size - 1);
}

int getmax(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  return heap[0];
}

void heapSort(int array[], int n) {
  size = 0; // resetting size for each new array since size is global
  int maxHeap[100];
  for (int i = 0; i < n; i++) {
    push(maxHeap, array[i]);
  }
  for (int i = 0; i < n; i++) {
    array[i] = pop(maxHeap);
  }
}

int main() {
  int randomSortedArray[] = {1, 5, 6, 2, 1, 3, 5, 6}; // 8 size
  int ascendingsorted[] = {1, 2, 3, 4, 5};            // 5 size
  int descendingSorted[] = {5, 4, 3, 2, 1};           // 5 size
  heapSort(randomSortedArray, 8);
  heapSort(ascendingsorted, 5);
  heapSort(descendingSorted, 5);
  printf("randomSortedArray \n");
  for (int i = 0; i < 8; i++) {
    printf("%d ", randomSortedArray[i]);
  }
  printf("\nAscending sorted input anser \n");
  for (int i = 0; i < 5; i++) {
    printf("%d ", ascendingsorted[i]);
  }
  printf("\nDescending Sorted input answer\n");
  for (int i = 0; i < 5; i++) {
    printf("%d ", descendingSorted[i]);
  }
  printf("\n");
  return 0;
}